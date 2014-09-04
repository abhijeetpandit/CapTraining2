package com.abhi.exception;

public class InsufficientInitialAmountException extends BankServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientInitialAmountException(String message) {
		super(message);
	}
}
