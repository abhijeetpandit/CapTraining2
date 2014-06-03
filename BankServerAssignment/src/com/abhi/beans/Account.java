package com.abhi.beans;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private int accountNumber;
	private double balance;
	private Customer customer;
	private List<Transaction> transactions = new ArrayList<>();
	
	public Account(int accountNumber, double initialAmount, Customer customer) {
		this.accountNumber = accountNumber;
		this.balance = initialAmount;
		this.customer = customer;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
}
