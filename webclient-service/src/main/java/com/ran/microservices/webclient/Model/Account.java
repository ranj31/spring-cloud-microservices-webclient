package com.ran.microservices.webclient.Model;

public class Account {

	private Integer id;
	private Integer customerId;
	private String number;
	private String accountType;
	private Customer customer;

	public Account() {

	}

	public Account(Integer id, Integer customerId, String number,String accountType) {
		this.id = id;
		this.customerId = customerId;
		this.number = number;
		this.accountType = accountType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
