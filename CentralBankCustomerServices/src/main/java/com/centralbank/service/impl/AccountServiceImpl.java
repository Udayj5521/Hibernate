package com.centralbank.service.impl;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.centralbank.entity.Account;
import com.centralbank.entity.Transaction;
import com.centralbank.exception.ResourceNotFoundException;
import com.centralbank.repository.AccountRepository;
import com.centralbank.service.AccountService;
import com.centralbank.service.TransactionService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired  
	private TransactionService transactionService;

	
	@Override
	public Account findAccountById(long accountId) {
		
		
		return accountRepository.findById(accountId).get();
	}

	@Override
	public Account findByType(String accounttype) {
		
		return  accountRepository.findByAccounttype(accounttype);
	}

	@Override
	public String deleteAccountById(long accountId) {
		
		Account account=accountRepository.findById(accountId).get();
		if(account==null) {
			return "Account [accountId="+accountId+"] can't be found";
		}
		else {
			accountRepository.deleteById(accountId);
			return "deleted the Account with [accountId="+accountId+"] ";
		}
		
	}

	@Override
	public String deleteAllAccounts() {
		
		accountRepository.deleteAll(); 
		return "all Accounts are deleted";
	}

	@Override
	public long getBalanceById(long accountId) {

		   return accountRepository.getBalanceByaccountId(accountId); 
		}


	@Override
	public long getBalnceByaccountNumber(long accountNumber) {
		// TODO Auto-generated method stub
		return accountRepository.getBalanceByaccountNumber(accountNumber);
	}

	@Override
	public Account updateAccount(long accountId,Account account) {
		// TODO Auto-generated method stub
		Account id=accountRepository.findById(accountId).get();
		if(id==null) {
			throw  new ResourceNotFoundException("account [accountId="+accountId+"] can't be found");
		        
		}else {
			return  accountRepository.save(account);
		}
		
	}

	@Override
	public Account create(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	@Override
	public List<Account> findAllAccounts() {
		List<Account> accountList=accountRepository.findAll();
		return accountList;
	}

	@Override
	public ResponseEntity<String> transferFunds(long from, long to, double amount) {
		
		
		Account fromAccount=accountRepository.getByaccountNumber(from);
		Account toAccount=accountRepository.getByaccountNumber(to);
		if(fromAccount==null) {
			throw new ResourceNotFoundException("account [accountNumber="+from+"] can't be found");
		}
		if(toAccount==null) {
			throw new ResourceNotFoundException("account [accountId="+to+"] can't be found");
		}
		else if(fromAccount.getBalance()>amount) {
		    List<Account>x=new ArrayList<>();
			fromAccount.setBalance(fromAccount.getBalance()-amount);
			toAccount.setBalance(toAccount.getBalance()+amount);
			accountRepository.save(fromAccount);
			accountRepository.save(toAccount);
			x.add(fromAccount);
			x.add(toAccount);
			Transaction transferFund=new Transaction("transaction bewteen [account="+from+"and"+to+"]",amount,x);
			transactionService.saveTransaction(transferFund);
		   return new ResponseEntity<>("Account balance has been updated successfully in the following accounts"+" "+from+"and"+" "+to+" ",HttpStatus.OK);
		}
		else {
		 throw new ResourceNotFoundException("acoount["+from+"]  does not have the enough balance");
		}
	}

	@Override
	public ResponseEntity<?> deposite(double amount,long accountNumber) {
	    
		Account account=accountRepository.getByaccountNumber(accountNumber);
		if(account==null) {
			throw new ResourceNotFoundException("account [accountNumber="+accountNumber+"] can't be found");
		}else {
		List<Account>x=new ArrayList<>();
		x.add(account);
		account.setBalance(account.getBalance()+amount);
		accountRepository.save(account);
		
		Transaction deposiTransaction=new Transaction("Deposite to account",amount,x);
		transactionService.saveTransaction(deposiTransaction);
		return new ResponseEntity<>("Sucessfully deposited",HttpStatus.OK);
	}
	}

	@Override
	public ResponseEntity<?> withdraw(double amount, long accountNumber) {
		Account account=accountRepository.getByaccountNumber(accountNumber);
		if(account==null) {
			throw new ResourceNotFoundException("account [accountNumber="+accountNumber+"] can't be found");
		}else {
	    List<Account>x=new ArrayList<>();
		x.add(account);
		account.setBalance(account.getBalance()-amount);
		accountRepository.save(account);
		Transaction withDraTransaction=new Transaction("Withdrwa from account",amount,x);
		transactionService.saveTransaction(withDraTransaction);
		return new ResponseEntity<>("withdrwa successully done!!",HttpStatus.OK);
	}
	}

	@Override
	public Account findAccountByAccountNumber(long accountNumber) {
		
		return accountRepository.findAccountByAccountNumber(accountNumber);
	}

	@Override
	public Account findAccountByCustomerId(long customerId) {
		
		return accountRepository.findAccountByAccountNumber(customerId);
	}
	
	}
	
