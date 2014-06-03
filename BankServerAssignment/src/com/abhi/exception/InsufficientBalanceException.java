package com.abhi.exception;

public class InsufficientBalanceException extends BankServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException(String message) {
		super(message);
	}
	
}
