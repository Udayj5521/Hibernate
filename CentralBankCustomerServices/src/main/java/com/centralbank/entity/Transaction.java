package com.centralbank.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class Transaction {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id",updatable = false)
  private long transactionId;
  @Column(name="amount")
  private double amount;
  
  @OneToMany
  @JoinColumn(name="accountNumber")
  private List<Account> account;

  @Column(name="comment")
  private String comment;

public Transaction() {
	super();
	
}


public Transaction(String comment, double amount, List<Account> account) {
	super();
	this.amount = amount;
	this.account=account;
	this.comment =comment;
}


@Override
public String toString() {
	return "Transaction [amount=" + amount + ", account=" + account + ", comment=" + comment + "]";
}

public long getTransactionId() {
	return transactionId;
}

public void setTransactionId(long transactionId) {
	this.transactionId = transactionId;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public List<Account> getAccount() {
	return account;
}

public void setAccount(List<Account> account) {
	this.account = account;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}
  	
}
