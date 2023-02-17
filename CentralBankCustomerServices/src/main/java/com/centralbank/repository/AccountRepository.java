package com.centralbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centralbank.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

	Account getByaccountNumber(long from);
    long getBalanceByaccountId(long accountId);
	long getBalanceByaccountNumber(long accountNumber);
    Account findAccountByAccountNumber(long accountNumber);
    Account findByAccounttype(String accounttype);
    
    
    
}
