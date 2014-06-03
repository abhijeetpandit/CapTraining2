package com.abhi.datarepo;

import java.util.HashMap;
import java.util.Map;

import com.abhi.beans.Account;
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
}
