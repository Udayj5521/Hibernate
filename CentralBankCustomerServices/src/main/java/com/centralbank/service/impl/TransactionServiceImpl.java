package com.centralbank.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centralbank.entity.Account;
import com.centralbank.entity.Customer;
import com.centralbank.entity.Transaction;
import com.centralbank.repository.AccountRepository;
import com.centralbank.repository.CustomerRepository;
import com.centralbank.repository.TransactionRepository;
import com.centralbank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public void saveTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
		
	}

	@Override
	public List<Transaction> findTransactionList(long accountNumber) {
		Account account=accountRepository.findAccountByAccountNumber(accountNumber);
		return account.getTransactions();
	}

	
	
	
	
}
