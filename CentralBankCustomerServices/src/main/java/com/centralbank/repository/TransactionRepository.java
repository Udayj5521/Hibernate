package com.centralbank.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.centralbank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

	List<Transaction> findAll();
	
	List<Transaction> findByAccountAccountNumber(long accountNumber);
	
}
