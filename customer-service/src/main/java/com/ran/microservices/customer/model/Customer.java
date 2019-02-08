package com.ran.microservices.customer.model;

import java.util.List;

public class Customer {

	private Integer id;
	private String aadhar;
	private String name;
	private CustomerType type;
	private List<Account> accounts;

	public Customer() {
		
	}
	
	public Customer(Integer id, String aadhar, String name, CustomerType type) {
		this.id = id;
		this.aadhar = aadhar;
		this.name = name;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
