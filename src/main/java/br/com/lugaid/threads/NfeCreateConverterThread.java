package br.com.lugaid.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lugaid.business.NfeCreateConvertToNfe;
import br.com.lugaid.params.NfeCreateImport;
import br.com.lugaid.parser.TNfeParser;
import br.com.lugaid.validator.XMLValidator;
import br.inf.portalfiscal.nfe.TNFe;

public class NfeCreateConverterThread extends Thread {
	private static Logger logger = LoggerFactory
			.getLogger(NfeCreateConverterThread.class);
	private Queue<NfeCreateImport> dataQueue = new LinkedList<>();
	private boolean isStarted = false;
	private static NfeCreateConverterThread converterThread;

	private NfeCreateConverterThread() {
	}

	public static NfeCreateConverterThread getInstance() {
		if (converterThread == null) {
			converterThread = new NfeCreateConverterThread();
		}

		return converterThread;
	}

	@Override
	public void run() {
		if (isStarted == true) {
			logger.warn("NfeCreate converter already started.");
		} else {
			// before any action set the thread name to split log files with
			// logback
			Thread.currentThread().setName("NfeCreateConverter");

			logger.info("Starting NfeCreate converter.");
			try {
				isStarted = true;
				convert();
			} catch (InterruptedException e) {
				logger.error("Error on NfeCreate converter {}.", e.getMessage());
				logger.debug("Stack trace ", e);
			}
		}
	}

	public synchronized void add(NfeCreateImport nfe) {
		if (isStarted == false) {
			this.start();
		}
		
		logger.debug("NfeCreateImport data {}.", nfe.toString());

		dataQueue.add(nfe);

		notify();
	}

	private synchronized void convert() throws InterruptedException {
		while (true) {
			if (dataQueue.size() == 0) {
				logger.info("Waitting for NfeCreate to convert.");
				wait();
				logger.info("Converting NfeCreate notified.");
			}

			for (NfeCreateImport nfe : dataQueue) {
				// Convert to TNFe type
				try {
					NfeCreateConvertToNfe convertToNfe = new NfeCreateConvertToNfe(
							nfe);
					TNFe tnfe = convertToNfe.convertToTNFe();

					// Parse TNFe to string
					String nfeXml = TNfeParser.parse(tnfe);

					// Validate nfe
					List<String> errors = XMLValidator
							.validateXml(
									"D:\\Projetos Java\\sap-to-rails-open-nfe-connector\\schemas\\3.10\\nfe_v3.10.xsd",
									nfeXml);

					System.out.println(errors);
				} catch (Exception e) {
					logger.error("Exception on conversion RFC parameters to NF-e.");
					logger.debug("Stack trace ", e);
				}

				dataQueue.remove(nfe);
			}
		}
	}
}
