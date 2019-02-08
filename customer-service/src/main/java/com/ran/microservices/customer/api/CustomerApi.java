package com.ran.microservices.customer.api;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ran.microservices.customer.model.Customer;
import com.ran.microservices.customer.repository.CustomerRepository;
import com.ran.microservices.customer.repository.CustomerRepositoryImpl;

@RestController
public class CustomerApi {
	@Autowired
	CustomerRepository customerRepository;
	
	protected Logger logger = Logger.getLogger(CustomerApi.class.getName());
	
	public CustomerApi() {
	}
	
	@RequestMapping("/customers/aadhar/{aadhar}")
	public Customer findByAadhar(@PathVariable("aadhar") String aadhar) {
		logger.info(String.format("Customer.findByAadhar(%s)", aadhar));
		return customerRepository.findByAadhar(aadhar);
	}
	
	@RequestMapping("/customers")
	public List<Customer> findAll() {
		logger.info("Customer.findAll()");
		return customerRepository.findAll();
	}
	
	@RequestMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") Integer id) {
		logger.info(String.format("Customer.findById(%s)", id));
		return customerRepository.findById(id);
	}
	
	@RequestMapping("/account/customer/{id}")
	public Customer findByCustId(@PathVariable("id") Integer id) {
		logger.info(String.format("RestTemplate called .. Customer.findByCustId(%s)", id));
		return customerRepository.findByCustId(id);
	}
}
