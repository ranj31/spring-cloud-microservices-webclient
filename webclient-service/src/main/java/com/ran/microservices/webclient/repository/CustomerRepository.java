/**
 * 
 */
package com.ran.microservices.webclient.repository;

import java.util.List;

import com.ran.microservices.webclient.Model.Account;
import com.ran.microservices.webclient.Model.Customer;

public interface CustomerRepository {
	List<Customer> findAll();
	Customer findById(Integer id);
	Customer findByAadhar(String number);
}
