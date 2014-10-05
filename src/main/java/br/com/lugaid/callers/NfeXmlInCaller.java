package br.com.lugaid.callers;

import br.com.lugaid.params.NfeXmlInImport;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;

public class NfeXmlInCaller {
	private static final String FM_NAME = "J_1B_NFE_XML_IN";
	private JCoDestination destination;

	public NfeXmlInCaller(JCoDestination destination) {
		this.destination = destination;
	}

	public boolean callFunctionModule(NfeXmlInImport nfeXmlInImport) {
		try {
			JCoFunction function = destination.getRepository().getFunction(
					FM_NAME);

			nfeXmlInImport.fillJCoParameter(function.getImportParameterList());

			function.execute(destination);

			return true;
		} catch (JCoException e) {
			e.printStackTrace();
			return false;
		}
	}
}
