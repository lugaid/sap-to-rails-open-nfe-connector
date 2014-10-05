package br.com.lugaid.exception;

public class IcmsException extends RuntimeException {
	private static final long serialVersionUID = -2169184363512352067L;

	public IcmsException() {
		super();
	}

	public IcmsException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IcmsException(String message, Throwable cause) {
		super(message, cause);
	}

	public IcmsException(String message) {
		super(message);
	}

	public IcmsException(Throwable cause) {
		super(cause);
	}
}