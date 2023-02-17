package com.centralbank.service;



import java.util.List;

import com.centralbank.entity.Customer;

public interface CustomerService {

	Customer cretaeCustomer(Customer customer);
	Customer findByCustomerName(String customerName);
	Customer findByCustomerId(long customerId);
	String  deleteById(long customerId);
	Customer  updateCustomer(long customerId,Customer customer);
	List<Customer> findListCustomers();
	String deleteAll();
	
	
}
