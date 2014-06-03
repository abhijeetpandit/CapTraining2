package com.abhi.datarepo;

import java.util.HashMap;
import java.util.Map;

import com.abhi.beans.Account;

public class AccountRepositoryImpl implements AccountRepository {

	private Map<Integer, Account> accounts = new HashMap<>();
	
	@Override
	public boolean saveAccount(Account account) {
		accounts.put(account.getAccountNumber(), account);
		return true;
	}

	@Override
	public Account readAccount(int accountNo) {
		return accounts.get(accountNo);
	}
}
