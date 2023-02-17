package com.centralbank.service;

import java.util.List;

import com.centralbank.entity.Transaction;

public interface TransactionService {

	List<Transaction> findTransactionList(long accountNumber);
	
	void saveTransaction(Transaction transaction);
	
	
	
}
