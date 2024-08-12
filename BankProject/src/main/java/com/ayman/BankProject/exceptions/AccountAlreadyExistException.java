package com.ayman.BankProject.exceptions;

import com.ayman.BankProject.beans.Account;

public class AccountAlreadyExistException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account existingAccount;

    public AccountAlreadyExistException(Account account)
    {
        this.existingAccount = account;
    }

    public Account getExistingAccount() {
        return existingAccount;
    }

}
