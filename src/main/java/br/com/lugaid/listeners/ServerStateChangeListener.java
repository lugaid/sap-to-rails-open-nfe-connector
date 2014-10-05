package br.com.lugaid.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sap.conn.jco.server.JCoServer;
import com.sap.conn.jco.server.JCoServerState;
import com.sap.conn.jco.server.JCoServerStateChangedListener;

public class ServerStateChangeListener implements JCoServerStateChangedListener {
	private static Logger logger = LoggerFactory
			.getLogger(ServerStateChangeListener.class);

	@Override
	public void serverStateChangeOccurred(JCoServer jCoServer,
			JCoServerState serverStateFrom, JCoServerState serverStateTo) {
		logger.info("State changed from {} to {}", serverStateFrom.toString(),
				serverStateTo.toString());
	}
}
