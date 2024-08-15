package com.ayman.BankProject.beans;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	private Integer accountId;
	
	
	@Column(name = "account_number")
	private Integer accountNumber;
	
	
	@Column(name = "account_type")
	private String accountType; 
	
	@Column(name="balance")
	private float balance;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	
	
	@OneToMany(mappedBy = "account")
	private List<Transaction> transactions;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	
	public Account() {
		super();
	}
	
	
	
	
	public Account(Integer accountNumber, String accountType, float balance, Status status) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
	}




	public Account(Integer accountId, Integer accountNumber, String accountType, float balance, Status status,
			List<Transaction> transactions, Customer customer) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
		this.transactions = transactions;
		this.customer = customer;
	}




	public Account(String accountType, float balance, Status status) {
		super();
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
	}

	
	

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}




	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", balance=" + balance + ", status=" + status + ", transactions=" + transactions + ", customer="
				+ customer + "]";
	}
	
	
	

}
