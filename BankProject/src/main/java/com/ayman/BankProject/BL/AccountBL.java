package com.ayman.BankProject.BL;

import org.springframework.beans.factory.annotation.Autowired;

import com.ayman.BankProject.beans.Account;
import com.ayman.BankProject.dao.AccountDAO;
import com.ayman.BankProject.exceptions.AccountAlreadyExistException;
import com.ayman.BankProject.exceptions.AccountNumberNotValidException;
import com.ayman.BankProject.exceptions.InvalidAccountException;

public class AccountBL {
	
	
	@Autowired
	private AccountDAO accountDAO;
	
	public Account addAccount(Account account) throws AccountAlreadyExistException, AccountNumberNotValidException, InvalidAccountException {
		
		
		if(account!=null) {
			
			if(account.getAccountNumber() == null) {
				throw new AccountNumberNotValidException();
			}
			Account existAccount = accountDAO.findAcoountByAccountNumber(account.getAccountNumber());
			if(existAccount != null) {
				throw new AccountAlreadyExistException(existAccount);
			}
			
			
		
			String accountNumString = String.valueOf(account.getAccountNumber());
			
			if(accountNumString.length()!=6 && checkIfContainChar(accountNumString)) {
					throw new AccountNumberNotValidException();
			}
			
			 return this.accountDAO.save(account);
		}
		
		throw new InvalidAccountException();
		
		
			
	}
	
	private boolean checkIfContainChar(String num) {
		for(char c :num.toCharArray()) {
			if(c < '0' || c > '9')
				return true;
			
		}
		return false;
	}
	

}
