package com.abhi.datarepo;

import com.abhi.beans.Account;

public interface AccountRepository {
	public boolean saveAccount(Account account);
	public Account readAccount(int accountNo);
}
