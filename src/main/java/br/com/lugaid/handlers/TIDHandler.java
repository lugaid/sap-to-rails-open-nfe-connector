package br.com.lugaid.handlers;

import java.util.Hashtable;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sap.conn.jco.server.JCoServerContext;
import com.sap.conn.jco.server.JCoServerTIDHandler;

public class TIDHandler implements JCoServerTIDHandler {
	private static Logger logger = LoggerFactory.getLogger(TIDHandler.class);

	private Map<String, TIDState> availableTIDs = new Hashtable<String, TIDState>();

	private enum TIDState {
		CREATED, EXECUTED, COMMITTED, ROLLED_BACK, CONFIRMED;
	}

	@Override
	public boolean checkTID(JCoServerContext serverContext, String tid) {
		TIDState state = availableTIDs.get(tid);

		if (state == null) {
			availableTIDs.put(tid, TIDState.CREATED);
			logger.info("CheckTID for {} returnning true.", tid);
			return true;
		}

		if (state == TIDState.CREATED || state == TIDState.ROLLED_BACK) {
			logger.info("CheckTID for {} returnning true.", tid);
			return true;
		} else {
			logger.info("CheckTID for {} returnning false.", tid);
			return false;
		}
	}

	@Override
	public void commit(JCoServerContext serverContext, String tid) {
		logger.info("Committing TID for {}.", tid);
		availableTIDs.put(tid, TIDState.COMMITTED);
	}

	@Override
	public void confirmTID(JCoServerContext serverContext, String tid) {
		logger.info("Confirming TID for {}.", tid);
		availableTIDs.put(tid, TIDState.CONFIRMED);
	}

	@Override
	public void rollback(JCoServerContext serverContext, String tid) {
		logger.info("Rolling back TID for {}.", tid);
		availableTIDs.put(tid, TIDState.ROLLED_BACK);
	}
}
