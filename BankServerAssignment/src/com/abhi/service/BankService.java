package com.abhi.service;

import java.util.List;

import com.abhi.beans.Customer;
import com.abhi.beans.Transaction;
import com.abhi.exception.InsufficientBalanceException;
import com.abhi.exception.InsufficientInitialAmountException;
import com.abhi.exception.InvalidAccountNumberException;

public interface BankService {
	
	public String createAccount(Customer c, double initialAmount) throws InsufficientInitialAmountException;
	
	public double showBalance(int accountNumber) throws InvalidAccountNumberException;
	
	public double withdraw(int accountNumber, double amount) throws 
		InvalidAccountNumberException, InsufficientBalanceException;
	
	public double deposit(int accountNumber, double amount) throws 
	InvalidAccountNumberException, InsufficientBalanceException;
	
	public double doTransaction(int sourceAccountNo, int destinationAcountNo, boolean isFundTransferFromSourceToDestination);
	
	public List<Transaction> printTransactions(int accountNumber) throws InvalidAccountNumberException;
}
