package br.com.lugaid.enuns;

public enum SAPMessageType {
	AUTH("1", "Authorization of NF-e"), 
	REJ("2", "Rejection of NF-e"), 
	DEN("3", "Denial of NF-e"), 
	AUTH_CANC_AUTH("4", "Authorization to Cancel an Authorized NF-e"), 
	AUTH_CANC_REJ("5", "Authorization to Cancel a Rejected NF-e (Skipping)"), 
	REJ_CANC("6", "Rejection of a Request for Cancellation"), 
	REJ_SKIPPING("7", "Rejection of a Request for Skipping"), 
	AUTH_SKIP("8", "Authorization to Skip a NF-e with Validation Error"), 
	REJ_SKIP_VAL("9", "Rejection to Skip a NF-e with Validation Error"), 
	MS_RECEIVED_AUTH("A", "MS Received: Request for Authorization"), 
	MS_RECEIVED_CANC("B", "MS Received: Cancellation Request"), 
	MS_RECEIVED_SKIPPING("C", "MS Received: Skipping Request");
	
	private String code;
	private String description;

	private SAPMessageType(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
