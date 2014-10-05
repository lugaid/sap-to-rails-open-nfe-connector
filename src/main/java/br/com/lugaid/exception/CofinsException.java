package br.com.lugaid.exception;

public class CofinsException extends RuntimeException {
	private static final long serialVersionUID = -1489029631396921036L;

	public CofinsException() {
		super();
	}

	public CofinsException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CofinsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CofinsException(String message) {
		super(message);
	}

	public CofinsException(Throwable cause) {
		super(cause);
	}
}