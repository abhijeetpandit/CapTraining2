package com.abhi.service;

import java.util.Date;
import java.util.List;

import com.abhi.beans.Account;
import com.abhi.beans.Customer;
import com.abhi.beans.Transaction;
import com.abhi.datarepo.AccountRepository;
import com.abhi.datarepo.AccountRepositoryImpl;
import com.abhi.exception.DataException;
import com.abhi.exception.InsufficientBalanceException;
import com.abhi.exception.InsufficientInitialAmountException;
import com.abhi.exception.InvalidAccountNumberException;

public class BankServiceImpl implements BankService{
	private AccountRepository accountRepository = new AccountRepositoryImpl();

	private static int STARTING_ACOUNT_NO = 999;
	private static int MIN_INITIAL_BAL = 2000;
	
	@Override
	public String createAccount(Customer c, double initialAmount)
			throws InsufficientInitialAmountException, DataException {
		validateCustomer(c);
		
		if(initialAmount < MIN_INITIAL_BAL) {
			throw new InsufficientInitialAmountException("Account not created. Initial amount is "
					+ initialAmount + " Minimum amount required is " + MIN_INITIAL_BAL);
		}
		Account account = new Account(STARTING_ACOUNT_NO++, initialAmount, c);
		accountRepository.saveAccount(account);
		return "Account is create account no is " + account.getAccountNumber() + " balance is " + account.getBalance();
	}

	@Override
	public double showBalance(int accountNumber)
			throws InvalidAccountNumberException {
		Account account = accountRepository.readAccount(accountNumber);
		return account.getBalance();
	}

	@Override
	public double withdraw(int accountNumber, double amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		Account account = accountRepository.readAccount(accountNumber);
		double newAccountBalance = account.getBalance() - amount;
		if(newAccountBalance < 0) {
			throw new InsufficientBalanceException("Insufficient " +
					"balance amount to be withdrawn = " + amount + " Balance in account = " + account.getBalance());
		}
		account.setBalance(newAccountBalance);
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setAvailableBalance(newAccountBalance);
		transaction.setDate(new Date());
		transaction.setDescription("Amount Debit = " + amount + " Ending balance = " + newAccountBalance);
		account.addTransaction(transaction);
		return newAccountBalance;
	}

	@Override
	public double deposit(int accountNumber, double amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		Account account = accountRepository.readAccount(accountNumber);
		double newAccountBalance = account.getBalance() + amount;
		account.setBalance(newAccountBalance);
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setAvailableBalance(newAccountBalance);
		transaction.setDate(new Date());
		transaction.setDescription("Amount Credit = " + amount + " Ending balance = " + newAccountBalance);
		account.addTransaction(transaction);
		return newAccountBalance;
	}

	@Override
	public String transferAmount(int sourceAccountNo, int destinationAcountNo, double amount) throws InvalidAccountNumberException, InsufficientBalanceException {
		Account sourceAccount = accountRepository.readAccount(sourceAccountNo);
		Account destinationAccount = accountRepository.readAccount(destinationAcountNo);
		
		double newSourceAccountBalance = sourceAccount.getBalance() - amount;
		if(newSourceAccountBalance < 0) {
			throw new InsufficientBalanceException("Insufficient balance in source account. Amount tried to withdraw = " + amount + " Balance in account = " + sourceAccount.getBalance());
		}
		double newDestinationAccountBalance = destinationAccount.getBalance() + amount;
		
		sourceAccount.setBalance(newSourceAccountBalance);
		destinationAccount.setBalance(newDestinationAccountBalance);
		
		Transaction sourceTransaction = new Transaction();
		sourceTransaction.setAmount(amount);
		sourceTransaction.setAvailableBalance(newSourceAccountBalance);
		sourceTransaction.setDate(new Date());
		sourceTransaction.setDescription("Amount Debit = " + amount + " Ending balance = " + newSourceAccountBalance + " Transferred to " + destinationAcountNo);
		sourceAccount.addTransaction(sourceTransaction);
		
		Transaction destinationTransaction = new Transaction();
		destinationTransaction.setAmount(amount);
		destinationTransaction.setAvailableBalance(newDestinationAccountBalance);
		destinationTransaction.setDate(new Date());
		destinationTransaction.setDescription("Amount Credit = " + amount + " Ending balance = " + newDestinationAccountBalance + " GOT from " + sourceAccountNo);
		destinationAccount.addTransaction(destinationTransaction);
		
		return "Transfer succesful. Trasfered amount " + amount + " source and destination"
		+ sourceAccountNo + "=>" + destinationAcountNo;
	}

	@Override
	public List<Transaction> printTransactions(int accountNumber)
			throws InvalidAccountNumberException {
		Account account = accountRepository.readAccount(accountNumber);
		return account.getTransactions();
	}
	
	private void validateCustomer(Customer c) throws DataException {
		checkNullAndThrowException(c, "Customer");
		checkNullAndThrowException(c.getFirstName(), "First name");
		checkNullAndThrowException(c.getLastName(), "Last name");
		checkNullAndThrowException(c.getAddress(), "Address");
		checkNullAndThrowException(c.getAddress().getAddressLine(), "Addressline name");
		checkNullAndThrowException(c.getAddress().getCity(), "City name");
		checkNullAndThrowException(c.getAddress().getCountry(), "Country name");
	}

	private void checkNullAndThrowException(Object object, String string) throws DataException {
		if(object == null) {
			throw new DataException("Invalid data " + string + " can not be null");
		}
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}
}
