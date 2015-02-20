package br.com.lugaid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.lugaid.handlers.NfeCreateHandler;
import br.com.lugaid.handlers.TIDHandler;
import br.com.lugaid.listeners.ServerStateChangeListener;
import br.com.lugaid.listeners.ServerThrowableListener;
import com.sap.conn.jco.JCo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.server.DefaultServerHandlerFactory;
import com.sap.conn.jco.server.DefaultServerHandlerFactory.FunctionHandlerFactory;
import com.sap.conn.jco.server.JCoServer;
import com.sap.conn.jco.server.JCoServerFactory;

/**
 * Singleton class to connect to SAP and start JCoServer with their default
 * handlers and listeners and also define the JCoDestination to be able to call
 * SAP RFC.
 */
public class SapConnector implements Runnable {
	private static Logger logger = LoggerFactory.getLogger(SapConnector.class);

	private static SapConnector sapConnector;
	private SapConnectorConfig sapConnectorConfig = SapConnectorConfig
			.getInstance();
	private JCoServer jCoServer;
	private JCoDestination jCodestination;

	private SapConnector() {
	}

	public static SapConnector getInstance() {
		if (sapConnector == null) {
			return new SapConnector();
		} else {
			return sapConnector;
		}
	}

	@Override
	public void run() {
		logger.info("Running SapConnector.");

		defineJCoServer();

		defineJCodestination();

		startDefaultHandlersAndListeners();

		startBusinessHandlers();

		// Start the server
		jCoServer.start();
	}

	/**
	 * Define JCoServer based on configuration file.
	 */
	private void defineJCoServer() {
		try {
			logger.info("Starting JCoServer.");

			// Set tracelevel and path to write log files
			JCo.setTrace(sapConnectorConfig.getJcoTraceLevel(), "logs/");

			jCoServer = JCoServerFactory.getServer(sapConnectorConfig
					.getJcoConfigName());

			logger.info("JCoServer succesfully started.");
			logger.info("==============================================================");
			logger.info("|                   SAP connection attributes");
			logger.info("| Host: {}", jCoServer.getGatewayHost());
			logger.info("| GatewayService: {}", jCoServer.getGatewayService());
			logger.info("| ProgramID: {}", jCoServer.getProgramID());
			logger.info("| RepositoryDestination: {}",
					jCoServer.getRepositoryDestination());
			logger.info("==============================================================");
		} catch (JCoException e) {
			logger.error("Error on get JCoServer ".concat(sapConnectorConfig
					.getJcoConfigName()));
			logger.debug("Stack trace ", e);
			throw new IllegalStateException("JCoServer error exiting system.",
					e);
		}
	}

	/**
	 * Define JCodestination based on configuration file.
	 */
	private void defineJCodestination() {
		try {
			logger.info("Definning destination to SAP.");

			jCodestination = JCoDestinationManager.getDestination(jCoServer
					.getRepositoryDestination());

			logger.info("Destination started to SAP.");
			logger.info("==============================================================");
			logger.info("|                   SAP connection attributes");
			logger.info("| Client: {}", jCodestination.getClient());
			logger.info("| User: {}", jCodestination.getUser());
			logger.info("| Language: {}", jCodestination.getLanguage());
			logger.info("| Sysnr: {}", jCodestination.getSystemNumber());
			logger.info("| Host: {}", jCodestination.getApplicationServerHost());
			logger.info("| RepositoryDestination: {}",
					jCoServer.getRepositoryDestination());
			logger.info("==============================================================");

		} catch (JCoException e) {
			logger.error("Error on get SAP server {}.",
					jCoServer.getRepositoryDestination());
			logger.debug("Stack trace ", e);
			throw new IllegalStateException(
					"SAP destination error exiting system.", e);
		}
	}

	/**
	 * Start default handlers and listeners
	 */
	private void startDefaultHandlersAndListeners() {
		jCoServer.addServerErrorListener(new ServerThrowableListener());

		jCoServer.addServerExceptionListener(new ServerThrowableListener());

		jCoServer
				.addServerStateChangedListener(new ServerStateChangeListener());

		jCoServer.setTIDHandler(new TIDHandler());
	}

	/**
	 * Start business handlers and callers
	 */
	private void startBusinessHandlers() {
		// Define FunctionHandlerFactory
		FunctionHandlerFactory functionHandlerFactory = new DefaultServerHandlerFactory.FunctionHandlerFactory();

		// Start J_1BNFE_OUTNFE_CREATE handler
		logger.info("Starting handler to function module {}",
				NfeCreateHandler.getFunctionModuleName());

		NfeCreateHandler nfeCreateHandler = NfeCreateHandler.getInstance();

		functionHandlerFactory.registerHandler(
				NfeCreateHandler.getFunctionModuleName(), nfeCreateHandler);

		// Set HandlerFactory into Server
		jCoServer.setCallHandlerFactory(functionHandlerFactory);
	}
}
