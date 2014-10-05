package br.com.lugaid.exception;

public class PisException extends RuntimeException {
	private static final long serialVersionUID = 6027024766257112322L;

	public PisException() {
		super();
	}

	public PisException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PisException(String message, Throwable cause) {
		super(message, cause);
	}

	public PisException(String message) {
		super(message);
	}

	public PisException(Throwable cause) {
		super(cause);
	}
}