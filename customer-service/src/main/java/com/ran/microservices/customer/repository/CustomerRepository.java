package com.ran.microservices.customer.repository;

import java.util.List;

import com.ran.microservices.customer.model.Customer;

public interface CustomerRepository {
	public Customer findByAadhar(String aadhar); 
	public List<Customer> findAll();
	public Customer findById(Integer id);
	public Customer findByCustId(Integer id);
}
