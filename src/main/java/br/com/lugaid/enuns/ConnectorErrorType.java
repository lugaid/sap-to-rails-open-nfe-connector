package br.com.lugaid.enuns;

public enum ConnectorErrorType {
	NFE_CONVERSION_EXCEPTION("001", "Exception on conversion RFC parameters to NF-e.", SAPMessageType.REJ);

	private String code;
	private String description;
	private SAPMessageType sapMessageType;

	private ConnectorErrorType(String code, String description, SAPMessageType sapMessageType) {
		this.code = code;
		this.description = description;
		this.sapMessageType = sapMessageType;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public SAPMessageType getSapMessageType() {
		return sapMessageType;
	}
}
