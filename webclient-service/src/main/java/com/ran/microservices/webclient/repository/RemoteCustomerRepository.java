package com.ran.microservices.webclient.repository;

import java.util.Arrays;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.ran.microservices.webclient.Model.Customer;

public class RemoteCustomerRepository implements CustomerRepository {
	
	@Autowired
	protected RestTemplate restTemplate;
	protected Logger logger = Logger.getLogger(RemoteCustomerRepository.class.getName());
	
	protected String customerServiceUrl;
	
	public RemoteCustomerRepository(String customerServiceUrl) {
			this.customerServiceUrl = customerServiceUrl.startsWith("http") ? customerServiceUrl
				: "http://" + customerServiceUrl;
	}
	
	@Override
	public List<Customer> findAll() {
		Customer[] customers = restTemplate.getForObject(customerServiceUrl+"/customers", Customer[].class);
		return Arrays.asList(customers);
	}

	@Override
	public Customer findById(Integer id) {
		return restTemplate.getForObject(customerServiceUrl + "/customers/{id}",Customer.class, id);
	}
	
	@Override
	public Customer findByAadhar(String aadhar) {
		return restTemplate.getForObject(customerServiceUrl + "/customers/aadhar/{aadhar}",Customer.class, aadhar);
	}
}
