package com.ayman.BankProject.BL;

import java.util.List;

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
	
	// Get an account by ID
    public Account getAccountById(Integer id) throws InvalidAccountException {
        List<Account> account = (List<Account>) AccountDAO.findAcoountByAccountId(id);
        if (account.isPresent()) {
            return account.get();
        } else {
            throw new InvalidAccountException("Account not found with ID: " + id);
        }
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountDAO.findAll();
    }

    // Update an existing account
    public Account updateAccount(Integer id, Account accountDetails) throws InvalidAccountException {
        Account account = getAccountById(id);

        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setAccountType(accountDetails.getAccountType());
        account.setBalance(accountDetails.getBalance());
        account.setStatus(accountDetails.getStatus());
        //account.setCustomer(accountDetails.getCustomer());

        return accountDAO.save(account);
    }

    // Delete an account
    public void deleteAccount(Integer id) throws InvalidAccountException {
        Account account = getAccountById(id);
        accountDAO.delete(account);
    }

	private boolean checkIfContainChar(String num) {
		for(char c :num.toCharArray()) {
			if(c < '0' || c > '9')
				return true;
			
		}
		return false;
	}
	

}
