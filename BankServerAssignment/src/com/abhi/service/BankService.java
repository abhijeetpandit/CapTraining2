package com.abhi.service;

import java.util.List;

import com.abhi.beans.Customer;
import com.abhi.beans.Transaction;
import com.abhi.exception.DataException;
import com.abhi.exception.InsufficientBalanceException;
import com.abhi.exception.InsufficientInitialAmountException;
import com.abhi.exception.InvalidAccountNumberException;

public interface BankService {
	
	public String createAccount(Customer c, double initialAmount) throws InsufficientInitialAmountException, DataException;
	
	public double showBalance(int accountNumber) throws InvalidAccountNumberException;
	
	public double withdraw(int accountNumber, double amount) throws 
		InvalidAccountNumberException, InsufficientBalanceException;
	
	public double deposit(int accountNumber, double amount) throws 
	InvalidAccountNumberException, InsufficientBalanceException;
	
	public String transferAmount(int sourceAccountNo, int destinationAcountNo, double amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	
	public List<Transaction> printTransactions(int accountNumber) throws InvalidAccountNumberException;
}
