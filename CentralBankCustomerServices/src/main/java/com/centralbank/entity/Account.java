package com.centralbank.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Account")
@Table
public class Account {

	@Id
	private long accountId;
	@Column(name="accountNumber")
	private long accountNumber;
	@Column(name="balance")
	private Double balance;

	@Column(name ="accounttype")
	private String accounttype;
	
    
	
	@OneToMany(mappedBy ="account",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Transaction>transactions=new ArrayList<>();

	
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public Account(){
		
		
	}
	
	

	
	public Account(long accountId, long accountNumber, Double balance, String accounttype,
			List<Transaction> transactions) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accounttype = accounttype;
		this.transactions =Collections.emptyList();
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", accounttype=" + accounttype + ", transactions=" + transactions + "]";
	}

	}

    