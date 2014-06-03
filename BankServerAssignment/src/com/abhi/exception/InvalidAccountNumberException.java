package com.abhi.exception;

public class InvalidAccountNumberException extends BankServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAccountNumberException(String message) {
		super(message);
	}
}
