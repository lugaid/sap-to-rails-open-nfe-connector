package br.com.lugaid.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sap.conn.jco.server.JCoServer;
import com.sap.conn.jco.server.JCoServerContextInfo;
import com.sap.conn.jco.server.JCoServerErrorListener;
import com.sap.conn.jco.server.JCoServerExceptionListener;

public class ServerThrowableListener implements JCoServerErrorListener,
		JCoServerExceptionListener {
	private static Logger logger = LoggerFactory
			.getLogger(ServerThrowableListener.class);
	
	@Override
	public void serverExceptionOccurred(JCoServer jCoServer, String connection,
			JCoServerContextInfo serverContext, Exception e) {
		logger.error("An exception occurred into connection {} error {}.", connection, e.toString());
		logger.debug("Stack trace ", e);
	}

	@Override
	public void serverErrorOccurred(JCoServer jCoServer, String connection,
			JCoServerContextInfo serverContext, Error error) {
		logger.error("An exception occurred into connection {} error {}.", connection, error);
	}
}