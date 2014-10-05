package br.com.lugaid;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lugaid.business.NfeCreateConvertToNfe;
import br.com.lugaid.handlers.NfeCreateHandler;
import br.com.lugaid.handlers.TIDHandler;
import br.com.lugaid.listeners.ServerStateChangeListener;
import br.com.lugaid.listeners.ServerThrowableListener;
import br.com.lugaid.params.NfeCreateImport;
import br.com.lugaid.params.NfeCreateImport.ItNfePartner;
import br.com.lugaid.threads.NfeCreateConverterThread;
import br.com.lugaid.threads.NfeXmlInCallerThread;

import com.sap.conn.jco.JCo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.server.DefaultServerHandlerFactory;
import com.sap.conn.jco.server.JCoServer;
import com.sap.conn.jco.server.JCoServerFactory;

public class SapConnector implements Runnable {
	private static Logger logger = LoggerFactory.getLogger(SapConnector.class);
	private static SapConnector sapConnector;

	private SapConnectorConfig sapConnectorConfig;

	protected SapConnector(SapConnectorConfig sapConnectorConfig) {
		this.sapConnectorConfig = sapConnectorConfig;
	}

	public static SapConnector getInstance() {
		if (sapConnector == null) {
			return new SapConnector(SapConnectorConfig.getInstance());
		} else {
			return sapConnector;
		}
	}

	@Override
	public void run() {
		logger.info("Start running SapConnector.");

		test();

		// start thread to converter
//		JCoServer jCoServer = getJCoServer();
//		
//		JCoDestination destination = getDestination(jCoServer);
//
//		NfeXmlInCallerThread nfeXmlInCallerThread = NfeXmlInCallerThread
//				.getInstance(destination, sapConnectorConfig);
//		nfeXmlInCallerThread.start();
//
//		NfeCreateHandler.getInstance(jCoServer, sapConnectorConfig, nfeXmlInCallerThread)
//				.startHandler();
//
//		// this method lock this thread take care with this
//		jCoServer.start();
	}

	private void test() {
		try {
			FileInputStream fileIn = new FileInputStream(
					"C:/temp/NfeCreateImport.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			NfeCreateImport nfe = (NfeCreateImport) in.readObject();
			in.close();
			fileIn.close();
			
			for(ItNfePartner  pt: nfe.getItNfePartners()) {
				pt.setNro("10");
			}

			// start thread to converter/
			JCoServer jCoServer = getJCoServer();
			JCoDestination destination = getDestination(jCoServer);

			NfeXmlInCallerThread nfeXmlInCallerThread = NfeXmlInCallerThread
					.getInstance(destination, sapConnectorConfig);
			nfeXmlInCallerThread.start();

			NfeCreateConverterThread converterThread = NfeCreateConverterThread
					.getInstance(sapConnectorConfig, nfeXmlInCallerThread);

			converterThread.start();
			converterThread.add(nfe);

		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return;
		}
	}

	private JCoServer getJCoServer() {
		try {
			logger.info("Starting connection to SAP.");

			// Set tracelevel and path to write log files
			JCo.setTrace(sapConnectorConfig.getJcoTraceLevel(), "logs/");

			JCoServer jCoServer = JCoServerFactory.getServer(sapConnectorConfig
					.getJcoConfigName());

			logger.info("Connection succesfully started to SAP.");
			logger.info("==============================================================");
			logger.info("|                   SAP connection attributes");
			logger.info("| Host: {}", jCoServer.getGatewayHost());
			logger.info("| GatewayService: {}", jCoServer.getGatewayService());
			logger.info("| ProgramID: {}", jCoServer.getProgramID());
			logger.info("| RepositoryDestination: {}",
					jCoServer.getRepositoryDestination());
			logger.info("==============================================================");

			startDefaultHandlersAndListeners(jCoServer);

			return jCoServer;
		} catch (JCoException e) {
			logger.error("Error on get SAP server ".concat(sapConnectorConfig
					.getJcoConfigName()));
			logger.debug("Stack trace ", e);
			throw new IllegalStateException("SAP server error exiting system.",
					e);
		}
	}

	private JCoDestination getDestination(JCoServer jCoServer) {
		try {
			logger.info("Starting destination to SAP.");

			JCoDestination destination = JCoDestinationManager
					.getDestination(jCoServer.getRepositoryDestination());

			logger.info("Destination started to SAP.");
			logger.info("==============================================================");
			logger.info("|                   SAP connection attributes");
			logger.info("| Client: {}", destination.getClient());
			logger.info("| User: {}", destination.getUser());
			logger.info("| Language: {}", destination.getLanguage());
			logger.info("| Sysnr: {}", destination.getSystemNumber());
			logger.info("| Host: {}", destination.getApplicationServerHost());
			logger.info("| RepositoryDestination: {}",
					jCoServer.getRepositoryDestination());
			logger.info("==============================================================");

			return destination;
		} catch (JCoException e) {
			logger.error("Error on get SAP server {}.",
					jCoServer.getRepositoryDestination());
			logger.debug("Stack trace ", e);
			throw new IllegalStateException(
					"SAP destination error exiting system.", e);
		}
	}

	private void startDefaultHandlersAndListeners(JCoServer jCoServer) {
		jCoServer
				.setCallHandlerFactory(new DefaultServerHandlerFactory.FunctionHandlerFactory());

		// Error, exception and state change listener
		jCoServer.addServerErrorListener(new ServerThrowableListener());
		jCoServer.addServerExceptionListener(new ServerThrowableListener());
		jCoServer
				.addServerStateChangedListener(new ServerStateChangeListener());

		jCoServer.setTIDHandler(new TIDHandler());
	}
}
