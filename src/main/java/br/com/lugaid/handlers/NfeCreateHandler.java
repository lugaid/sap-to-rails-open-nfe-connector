package br.com.lugaid.handlers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.lugaid.params.NfeCreateImport;
import br.com.lugaid.threads.NfeCreateConverterThread;
import com.sap.conn.jco.AbapClassException;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.server.JCoServerContext;
import com.sap.conn.jco.server.JCoServerFunctionHandler;

public class NfeCreateHandler implements JCoServerFunctionHandler {
	private static Logger logger = LoggerFactory
			.getLogger(NfeCreateHandler.class);
	private static final String FUNCTION_MODULE_NAME = "J_1BNFE_OUTNFE_CREATE";
	private static NfeCreateHandler nfeCreateHandler;
	private NfeCreateConverterThread converterThread = NfeCreateConverterThread
			.getInstance();

	private NfeCreateHandler() {
	}

	@Override
	public void handleRequest(JCoServerContext serverContext,
			JCoFunction function) throws AbapException, AbapClassException {

		JCoParameterList impParmList = function.getImportParameterList();
		logger.info("Handling {}.", FUNCTION_MODULE_NAME);
		logger.debug("Data received from {}: {}.", FUNCTION_MODULE_NAME,
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

	public static NfeCreateHandler getInstance() {
		if (nfeCreateHandler == null) {
			return new NfeCreateHandler();
		} else {
			return nfeCreateHandler;
		}
	}

	public static String getFunctionModuleName() {
		return FUNCTION_MODULE_NAME;
	}
}
