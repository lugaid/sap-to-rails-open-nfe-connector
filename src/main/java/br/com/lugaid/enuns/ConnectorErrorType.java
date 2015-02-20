package br.com.lugaid.enuns;

/**
 * Possible errors that can occurs into connector and their respective SAP
 * message type to return to SAP.
 */
public enum ConnectorErrorType {
	NFE_CONVERSION_EXCEPTION("001",
			"Exception on conversion RFC parameters to NF-e.",
			SAPMessageType.REJ);

	private String code;
	private String description;
	private SAPMessageType sapMessageType;

	private ConnectorErrorType(String code, String description,
			SAPMessageType sapMessageType) {
		this.code = code;
		this.description = description;
		this.sapMessageType = sapMessageType;
	}

	/**
	 * Returns code
	 * 
	 * @return Code as String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Returns description
	 * 
	 * @return Description as String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return
	 */
	public SAPMessageType getSapMessageType() {
		return sapMessageType;
	}
}
