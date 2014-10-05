package br.com.lugaid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 
 */
public class SAP2RailsOpenNfeConnector {
	private static Logger logger = LoggerFactory
			.getLogger(SAP2RailsOpenNfeConnector.class);

	public static void main(String[] args) {
		logger.info("Starting SAP2RailsOpenNfeConnector system.");
		
		SapConnector sapConnector = SapConnector.getInstance();
		sapConnector.run();
	}
}
