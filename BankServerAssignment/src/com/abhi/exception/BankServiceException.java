package com.abhi.exception;

public class BankServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BankServiceException(String message) {
		super(message);
	}
}
