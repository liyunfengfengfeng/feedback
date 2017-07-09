package com.hrbust.feedback.domain;

public class FeedBackException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FeedBackException() {
		super();
	}

	public FeedBackException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public FeedBackException(String message) {
		super(message);
	}
	
	public FeedBackException(Throwable cause) {
		super(cause);
	}

}
