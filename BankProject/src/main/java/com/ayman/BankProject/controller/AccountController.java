package com.ayman.BankProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ayman.BankProject.BL.AccountBL;
import com.ayman.BankProject.beans.Account;
import com.ayman.BankProject.exceptions.AccountAlreadyExistException;
import com.ayman.BankProject.exceptions.AccountNumberNotValidException;
import com.ayman.BankProject.exceptions.InvalidAccountException;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountBL accountBL;

    // Create a new account
    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        try {
            Account createdAccount = accountBL.addAccount(account);
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } catch (AccountAlreadyExistException | AccountNumberNotValidException | InvalidAccountException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Get an account by ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer id) {
        Account account = accountBL.getAccountById(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Get all accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountBL.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // Update an existing account
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Integer id, @RequestBody Account account) {
        try {
            Account updatedAccount = accountBL.updateAccount(id, account);
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        } catch (InvalidAccountException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete an account
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Integer id) {
        try {
            accountBL.deleteAccount(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (InvalidAccountException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
