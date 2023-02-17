package com.centralbank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centralbank.entity.Customer;
import com.centralbank.exception.ResourceNotFoundException;
import com.centralbank.repository.CustomerRepository;
import com.centralbank.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer cretaeCustomer(Customer customer) {
	
		return customerRepository.save(customer);
	}

	@Override
	public Customer findByCustomerName(String customerName) {
		
		return customerRepository.findByCustomerName(customerName);
	}
	
	@Override
	public Customer findByCustomerId(long customerId) {
          
		Optional<Customer> x=customerRepository.findById(customerId);
		if(x.isPresent()) {
		         return x.get();
		         }else {
			
			    throw new ResourceNotFoundException("customer [customerId="+customerId+"] can't be found");
		   }
	}
	@Override
	public String deleteById(long customerId) {
	Customer customer=customerRepository.findById(customerId).get();
		if(customer==null) {
			return "Account [accountId="+customerId+"] can't be found";
		}
		else {
			customerRepository.deleteById(customerId);
			return "deleted the Account with [accountId="+customerId+"] ";
		}
		
	}

	@Override
	public String deleteAll() {
		customerRepository.deleteAll();
		return "all customers are deleted";
	}

	@Override
	public Customer updateCustomer(long customerId, Customer customer) {
		Customer x=customerRepository.findById(customerId).get();
		if(x==null) {
			throw  new ResourceNotFoundException("customer [customerId="+customerId+"] can't be found");
		        
		}else {
			return  customerRepository.save(customer);
		}
		
	}

	@Override
	public List<Customer> findListCustomers() {
	    
		List<Customer> customerList=customerRepository.findAll();
		return customerList;
	}
	
	   
	
	
}
