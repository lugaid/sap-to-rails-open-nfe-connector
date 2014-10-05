package br.com.lugaid.exception;

public class IpiException extends RuntimeException {
	private static final long serialVersionUID = -4825215894373013052L;

	public IpiException() {
		super();
	}

	public IpiException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IpiException(String message, Throwable cause) {
		super(message, cause);
	}

	public IpiException(String message) {
		super(message);
	}

	public IpiException(Throwable cause) {
		super(cause);
	}
}