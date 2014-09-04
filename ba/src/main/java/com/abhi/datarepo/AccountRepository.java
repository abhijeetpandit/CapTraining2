package com.abhi.datarepo;

import com.abhi.beans.Account;
import com.abhi.exception.InvalidAccountNumberException;

public interface AccountRepository {
	public boolean saveAccount(Account account);
	public Account readAccount(int accountNo) throws InvalidAccountNumberException;
}
