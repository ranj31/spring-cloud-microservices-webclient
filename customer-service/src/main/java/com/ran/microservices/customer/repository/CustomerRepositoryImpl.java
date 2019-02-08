package com.ran.microservices.customer.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.ran.microservices.customer.intercomm.AccountClient;
import com.ran.microservices.customer.model.Account;
import com.ran.microservices.customer.model.Customer;
import com.ran.microservices.customer.model.CustomerType;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	private List<Customer> customers;
	
	@Autowired
	private AccountClient accountClient;
	public CustomerRepositoryImpl() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "12345", "Sanjoy Moni", CustomerType.INDIVIDUAL));
		customers.add(new Customer(2, "12346", "Rajen Chatterjee", CustomerType.INDIVIDUAL));
		customers.add(new Customer(3, "12347", "Vijoy Chakraborty", CustomerType.INDIVIDUAL));
		customers.add(new Customer(4, "12348", "Sachidanand Dusad", CustomerType.INDIVIDUAL));
	}

	public Customer findByAadhar(@PathVariable("aadhar") String aadhar) {
		return customers.stream().filter(it -> it.getAadhar().equals(aadhar)).findFirst().get();	
	}
	
	public List<Customer> findAll() {
		return customers;
	}
	
	public Customer findById(@PathVariable("id") Integer id) {
		Customer customer = customers.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
		List<Account> accounts =  accountClient.getAccounts(id);
		customer.setAccounts(accounts);
		return customer;
	}
	
	public Customer findByCustId(@PathVariable("id") Integer id) {
		Customer customer = customers.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
		return customer;
	}
	
}
