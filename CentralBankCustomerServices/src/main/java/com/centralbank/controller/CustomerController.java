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

import com.centralbank.entity.Customer;
import com.centralbank.entity.Transaction;
import com.centralbank.exception.ResourceNotFoundException;
import com.centralbank.service.CustomerService;
import com.centralbank.service.TransactionService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	TransactionService transactionService;

	@PostMapping
	public ResponseEntity<?> CreateCustomer(@RequestBody Customer customer){
		Customer cus=customerService.cretaeCustomer(customer);
		if(cus!=null) {
			return new ResponseEntity<>(cus,HttpStatus.CREATED);
		}else {
			throw new ResourceNotFoundException("customer not created!!");
		}
		
		
	}
	
	@GetMapping("/getByName")
	public ResponseEntity<?> getCustomerByName(@PathVariable String customerName){
		Customer customer=customerService.findByCustomerName(customerName);
		if(customer!=null) {
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Invalid customername");
		}
		
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getCustomerById(@PathVariable long customerId){
		Customer customer=customerService.findByCustomerId(customerId);
		if(customer!=null) {
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Invalid customerId");
		}
		
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteByI(@PathVariable long customerId){
		String x=customerService.deleteById(customerId);
		if(x.equalsIgnoreCase("deleted the Account with [accountId="+customerId+"]")) {
			return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("Invalid customerId");
		}		
	}
	@DeleteMapping("/deleteAll")
	public ResponseEntity<?> deleteAll(){
		return new ResponseEntity<>(customerService.deleteAll(),HttpStatus.OK);
	}

	
	@PutMapping("/update/{customerId}")
	public ResponseEntity<?> update(@PathVariable long customerId,@RequestBody Customer customer){
		Customer cust=customerService.updateCustomer(customerId, customer);
		if(cust!=null) {
			return new ResponseEntity<>(cust,HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("customer not updated!!");
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> customerList(){
		List<Customer> list=customerService.findListCustomers();
		if(!(list.isEmpty())) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}else {
			throw new ResourceNotFoundException("not customer found");
		}
	}
	
	
}


