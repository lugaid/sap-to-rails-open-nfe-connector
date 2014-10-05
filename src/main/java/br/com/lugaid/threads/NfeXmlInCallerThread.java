package br.com.lugaid.threads;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.conn.jco.JCoDestination;

import br.com.lugaid.SapConnectorConfig;
import br.com.lugaid.callers.NfeXmlInCaller;
import br.com.lugaid.enuns.ConnectorErrorType;
import br.com.lugaid.params.NfeXmlInImport;
import br.com.lugaid.params.NfeXmlInImport.IAcckey;

public class NfeXmlInCallerThread extends Thread {
	private static Logger logger = LoggerFactory
			.getLogger(NfeXmlInCallerThread.class);
	private JCoDestination destination;
	private SapConnectorConfig sapConnectorConfig;
	private Queue<NfeXmlInImport> dataQueue = new LinkedList<>();
	private boolean isStarted = false;
	private static NfeXmlInCallerThread callerThread;
	private NfeXmlInCaller nfeXmlInCaller;

	private NfeXmlInCallerThread(JCoDestination destination,
			SapConnectorConfig sapConnectorConfig) {
		this.destination = destination;
		this.sapConnectorConfig = sapConnectorConfig;
	}

	public static NfeXmlInCallerThread getInstance(JCoDestination destination,
			SapConnectorConfig sapConnectorConfig) {
		if (callerThread == null) {
			callerThread = new NfeXmlInCallerThread(destination,
					sapConnectorConfig);
		}

		return callerThread;
	}

	@Override
	public void run() {
		if (isStarted == true) {
			logger.warn("NfeXmlIn caller already started.");
		} else {
			// before any action set the thread name to split log files with
			// logback
			Thread.currentThread().setName("NfeXmlInCaller");

			logger.info("Starting NfeXmlIn caller.");

			nfeXmlInCaller = new NfeXmlInCaller(destination);

			try {
				isStarted = true;
				call();
			} catch (InterruptedException e) {
				logger.error("Error on NfeXmlIn caller {}.", e.getMessage());
				logger.debug("Stack trace ", e);
			}
		}
	}

	public synchronized void addConnectorError(long docnum,
			ConnectorErrorType connectorErrorType) {
		logger.info("Adding connector error to call NfeXmlIn.");

		IAcckey acckey = new IAcckey(null, null, null, null, null, null, null,
				null, null);
		NfeXmlInImport nfeXmlInImport = new NfeXmlInImport(acckey, null, null,
				null, connectorErrorType.getCode(), docnum, null,
				connectorErrorType.getSapMessageType().getCode());

		add(nfeXmlInImport);
	}

	public synchronized void add(NfeXmlInImport nfeXmlInImport) {
		logger.info("Adding NfeXmlIn to call.");

		dataQueue.add(nfeXmlInImport);

		notify();
	}

	private synchronized void call() throws InterruptedException {
		while (true) {
			if (dataQueue.size() == 0) {
				logger.info("Waitting for NfeXmlIn to call.");
				wait();
				logger.info("Call NfeXmlIn notified.");
			}

			for (NfeXmlInImport nfeXmlInImport : dataQueue) {
				// Call NfeXmlIn
				nfeXmlInCaller.callFunctionModule(nfeXmlInImport);

				// Parse TNFe to string
				dataQueue.remove(nfeXmlInImport);
			}
		}
	}
}
