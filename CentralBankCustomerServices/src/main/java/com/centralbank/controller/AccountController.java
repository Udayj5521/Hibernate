package com.centralbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.centralbank.entity.Account;
import com.centralbank.entity.Transaction;
import com.centralbank.exception.ResourceNotFoundException;
import com.centralbank.service.AccountService;
import com.centralbank.service.TransactionService;

@RestController
@RequestMapping("/account")
public class AccountController {
@Autowired
AccountService accountService;
@Autowired
TransactionService transactionService;

@PostMapping("/save")
public ResponseEntity<?>  createAccount(@RequestBody Account account){
	
	Account acc=accountService.create(account);
	if(acc!=null) {
		return new ResponseEntity<>(acc,HttpStatus.CREATED);
	}else {
		throw new ResourceNotFoundException("account not created!!");
	}
	
}

@GetMapping
public ResponseEntity<?> getAll(){
	List<Account> accountList=accountService.findAllAccounts();
	if(!(accountList.isEmpty())) {
		return new ResponseEntity<>(accountList,HttpStatus.OK);
	}else {
		throw new ResourceNotFoundException("accounts not found");
	}
}

@GetMapping("/byType")
public ResponseEntity<?> byAccountType(@PathVariable String accountType){
	List<Account> accountTypeList=(List<Account>) accountService.findByType(accountType);
	if(accountTypeList.isEmpty()) {
		throw new ResourceNotFoundException(accountType+""+"Type of account does not exist!!");
	}else {
		return new ResponseEntity<>(accountType,HttpStatus.OK);
	}
}

@GetMapping("/{accountId}")
public ResponseEntity<?> getAccountById(@PathVariable long accountId){
	Account acc=accountService.findAccountById(accountId);
	if(acc!=null) {
		return new ResponseEntity<>(acc,HttpStatus.OK);
	}else {
		throw new ResourceNotFoundException("account [accountId="+accountId+"] can't be found");
	}
}

@PutMapping("/{fromAcc}/{toAcc}/{amount}")
public ResponseEntity<?> transferFunds(@PathVariable long from,@PathVariable long to,double amount){
	
   return accountService.transferFunds(from, to, amount);		
}

@DeleteMapping("/{accountId}")
public ResponseEntity<?> deleteAccById(@PathVariable long accountId){
	String x=accountService.deleteAccountById(accountId);
	if(x.equalsIgnoreCase("deleted the Account with [accountId="+accountId+"]")){
		return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
	}else {
		throw new ResourceNotFoundException("Account [accountId="+accountId+"] can't be find");
	}
}

@GetMapping("/balance/{accountId}")
public ResponseEntity<?> getBalanceById(@PathVariable long accountId){
	long balance=accountService.getBalanceById(accountId);
	Account account=accountService.findAccountById(accountId);
	if(account!=null) {
		return new ResponseEntity<>(balance,HttpStatus.OK);
	}else {
		throw new ResourceNotFoundException("Account [accountId="+accountId+"] can't be found");
	}
	
}

@GetMapping("/balance/{accountNumber}")
public ResponseEntity<?> getBalanceByAccountNumber(@PathVariable long accountNumber){
	
	Account account=accountService.findAccountByAccountNumber(accountNumber);
	if(account!=null) {
		return new ResponseEntity<>(accountService.getBalnceByaccountNumber(accountNumber),HttpStatus.OK);
	}else {
		throw new ResourceNotFoundException("Account [accountNumber="+accountNumber+"] can't be found");	
	}
	
}
@DeleteMapping("/deleteAll")
public ResponseEntity<?> deleteAllAccounts(){
	return new ResponseEntity<>(accountService.deleteAllAccounts(),HttpStatus.OK);
}

@PutMapping("/update/{accountId}")
public ResponseEntity<?> UpdateAccount(@PathVariable long accountId,@RequestBody Account account){
	Account acc=accountService.updateAccount(accountId, account);
	if(acc!=null) {
		return new ResponseEntity<>(acc,HttpStatus.OK);
	}else {
		throw new ResourceNotFoundException("invalid accountId and account");
	}
}

@GetMapping("/{AccNumber}")
public ResponseEntity<?> getAccountByAccountNumber(@PathVariable long accountNumber){
	Account acc=accountService.findAccountByAccountNumber(accountNumber);
	if(acc!=null) {
		return new ResponseEntity<>(acc,HttpStatus.OK);
	}
	else {
		throw new ResourceNotFoundException("Invalid accountNumber"+accountNumber);
	}
	
	
}

@PutMapping("/deposite/{accNumber}/{amount}")
public ResponseEntity<?> deposite(@PathVariable double amount,@PathVariable long accountNumber){
	
	return accountService.deposite(amount, accountNumber);
}

@PutMapping("/withdraw/{accNumber}/{amount}")	
public ResponseEntity<?> withDraw(@PathVariable double amount,@PathVariable long accountNumber){
	
	return accountService.withdraw(amount, accountNumber);
}

@GetMapping("/transaction")
public ResponseEntity<?> transactionList(long accountId){
	
	List<Transaction> tra=transactionService.findTransactionList(accountId);
	if(!(tra.isEmpty())){
		return new ResponseEntity<>(tra,HttpStatus.OK);
	}else {
		throw new ResourceNotFoundException(" invalid customerId");
	}
}




}
