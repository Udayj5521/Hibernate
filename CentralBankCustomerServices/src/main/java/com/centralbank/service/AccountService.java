package com.centralbank.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.centralbank.entity.Account;

public interface AccountService {

    Account create(Account account);
	Account findAccountById(long accountId);
	List<Account> findAllAccounts();
	Account findByType(String accounttype);
    ResponseEntity<String> transferFunds(long from,long to,double amount);
	String deleteAccountById(long accountId);
	String deleteAllAccounts();
	long getBalanceById(long accountId);
	long getBalnceByaccountNumber(long accountNumber);
    Account updateAccount(long accountId,Account account);
    ResponseEntity<?> deposite(double amount,long accountNumber);
    ResponseEntity<?> withdraw(double amount,long accountNumber);
	Account findAccountByAccountNumber(long accountNumber);
	Account findAccountByCustomerId(long customerId);
    
	
}