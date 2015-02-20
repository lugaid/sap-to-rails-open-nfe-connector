package br.com.lugaid;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lugaid.params.NfeCreateImport;
import br.com.lugaid.params.NfeCreateImport.ItNfePartner;
import br.com.lugaid.threads.NfeCreateConverterThread;

/**
 * Bootstrap to SAP2RailsOpenNfeConnector.
 */
public class SAP2RailsOpenNfeConnector {
	private static Logger logger = LoggerFactory
			.getLogger(SAP2RailsOpenNfeConnector.class);

	/**
	 * Start manually.
	 */
	public static void main(String[] args) {
		//start();
		SapConnectorConfig.getInstance();
		test();
	}

	/**
	 * Start as service.
	 */
	public static void start() {
		logger.info("Starting SAP2RailsOpenNfeConnector system.");

		SapConnector.getInstance().run();
	}

	/**
	 * Stop service.
	 */
	public static void stop() {
		logger.info("Stopping SAP2RailsOpenNfeConnector system.");
	}
	
	@SuppressWarnings("unused")
	private static void test() {
		NfeCreateConverterThread converterThread = NfeCreateConverterThread
				.getInstance();
		NfeCreateImport nfeCreateImport = null;
		
		try {
			FileInputStream fileInp = new FileInputStream(
					"C:/temp/NfeCreateImport.ser");
			ObjectInputStream inp = new ObjectInputStream(fileInp);
			nfeCreateImport = (NfeCreateImport)inp.readObject();
			inp.close();
			fileInp.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		converterThread.add(nfeCreateImport);
	}
}
