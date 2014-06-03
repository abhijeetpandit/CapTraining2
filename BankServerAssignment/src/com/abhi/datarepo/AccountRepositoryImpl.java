package com.abhi.datarepo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.abhi.beans.Account;
import com.abhi.beans.Transaction;
import com.abhi.exception.InvalidAccountNumberException;

public class AccountRepositoryImpl implements AccountRepository {

	private Map<Integer, Account> accounts = new HashMap<>();
	
	@Override
	public boolean saveAccount(Account account) {
		accounts.put(account.getAccountNumber(), account);
		return true;
	}

	@Override
	public Account readAccount(int accountNo) throws InvalidAccountNumberException {
		Account account =  accounts.get(accountNo);
		if(account == null) {
			throw new InvalidAccountNumberException("Account with account number" + accountNo + " not found");
		} else {
			return account;
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Entry<Integer, Account> entry : accounts.entrySet()) {
			Account account = entry.getValue();
			stringBuilder.append(entry.getKey()).append(":").append("accountNo=" + account.getAccountNumber() + " Balance=" + account.getBalance());
			stringBuilder.append("\n");
			for(Transaction transaction : account.getTransactions()) {
				stringBuilder.append(transaction.toString()).append("\n");
			}
		}
		return stringBuilder.toString();//"AccountRepositoryImpl [accounts=" + accounts + "]";
	}
	
}
