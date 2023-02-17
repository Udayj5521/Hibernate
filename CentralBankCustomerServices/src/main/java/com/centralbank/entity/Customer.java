package com.centralbank.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="customer")
@Entity
public class Customer {

	@Id
	private long customerId;
	@Column(name="customerName")
	private String customerName;
	
	
	
	@OneToMany(targetEntity = Account.class,cascade=CascadeType.ALL)
	@JoinColumn(name="ca_fk",referencedColumnName = "customerId")
	private List<Account> account;

     
	
	

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}	
	
	public Customer() {
		super();
		
	}

	public Customer(long customerId, String customerName, List<Account> account) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
        this.account=account;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", account=" + account + "]";
	}
		
}
