package com.abhi.service;

import java.util.List;

import com.abhi.beans.Account;
import com.abhi.beans.Customer;
import com.abhi.beans.Transaction;
import com.abhi.datarepo.AccountRepository;
import com.abhi.datarepo.AccountRepositoryImpl;
import com.abhi.exception.InsufficientBalanceException;
import com.abhi.exception.InsufficientInitialAmountException;
import com.abhi.exception.InvalidAccountNumberException;

public class BankServiceImpl implements BankService{
	private AccountRepository accountRepository = new AccountRepositoryImpl();

	private static int STARTING_ACOUNT_NO = 999;
	private static int MIN_INITIAL_BAL = 2000;
	
	@Override
	public String createAccount(Customer c, double initialAmount)
			throws InsufficientInitialAmountException {
		//TODO - Add validation for customer fields
		
		if(initialAmount < MIN_INITIAL_BAL) {
			throw new InsufficientInitialAmountException("Initial amount is "
					+ initialAmount + "Minimum amount required is " + MIN_INITIAL_BAL);
		}
		Account account = new Account(STARTING_ACOUNT_NO++, initialAmount, c);
		accountRepository.saveAccount(account);
		return null;
	}

	@Override
	public double showBalance(int accountNumber)
			throws InvalidAccountNumberException {
		
		return 0;
	}

	@Override
	public double withdraw(int accountNumber, double amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double deposit(int accountNumber, double amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doTransaction(int sourceAccountNo, int destinationAcountNo,
			boolean isFundTransferFromSourceToDestination) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Transaction> printTransactions(int accountNumber)
			throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
