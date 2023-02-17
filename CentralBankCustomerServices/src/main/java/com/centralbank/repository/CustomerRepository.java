package com.centralbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centralbank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByCustomerName(String customerName);

	
}
