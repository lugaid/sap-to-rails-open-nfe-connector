package br.com.lugaid.handlers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lugaid.SapConnectorConfig;
import br.com.lugaid.params.NfeCreateImport;
import br.com.lugaid.threads.NfeCreateConverterThread;
import br.com.lugaid.threads.NfeXmlInCallerThread;

import com.sap.conn.jco.AbapClassException;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.server.DefaultServerHandlerFactory;
import com.sap.conn.jco.server.JCoServer;
import com.sap.conn.jco.server.JCoServerContext;
import com.sap.conn.jco.server.JCoServerFunctionHandler;

public class NfeCreateHandler implements JCoServerFunctionHandler {
	private static Logger logger = LoggerFactory
			.getLogger(NfeCreateHandler.class);
	private static final String FUNCTION_MODULE = "J_1BNFE_OUTNFE_CREATE";
	private static NfeCreateHandler nfeCreateHandler;
	private JCoServer jCoServer;
	private NfeCreateConverterThread converterThread;
	private NfeXmlInCallerThread nfeXmlInCallerThread;

	protected NfeCreateHandler(JCoServer jCoServer,
			NfeCreateConverterThread converterThread,
			NfeXmlInCallerThread nfeXmlInCallerThread) {
		this.jCoServer = jCoServer;
		this.converterThread = converterThread;
		this.nfeXmlInCallerThread = nfeXmlInCallerThread;
	}

	@Override
	public void handleRequest(JCoServerContext serverContext,
			JCoFunction function) throws AbapException, AbapClassException {

		JCoParameterList impParmList = function.getImportParameterList();
		logger.info("Handling {}.", FUNCTION_MODULE);
		logger.debug("Data received from {}: {}.", FUNCTION_MODULE,
				impParmList.toXML());

		NfeCreateImport nfeCreateImport = new NfeCreateImport(impParmList);
		
		converterThread.add(nfeCreateImport);

		try {
			FileOutputStream fileOut = new FileOutputStream(
					"C:/temp/NfeCreateImport.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(nfeCreateImport);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static NfeCreateHandler getInstance(JCoServer jCoServer,
			SapConnectorConfig sapConnectorConfig,
			NfeXmlInCallerThread nfeXmlInCallerThread) {
		if (nfeCreateHandler == null) {
			return new NfeCreateHandler(jCoServer,
					NfeCreateConverterThread.getInstance(sapConnectorConfig,
							nfeXmlInCallerThread), nfeXmlInCallerThread);
		} else {
			return nfeCreateHandler;
		}
	}

	@SuppressWarnings("unchecked")
	public void startHandler() {
		converterThread.start();

		logger.info("Starting handler to function module {}", FUNCTION_MODULE);
		((DefaultServerHandlerFactory<JCoServerFunctionHandler>) jCoServer
				.getCallHandlerFactory())
				.registerHandler(FUNCTION_MODULE, this);

	}
}
