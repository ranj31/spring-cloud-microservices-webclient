package com.ran.microservices.account.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.ran.microservices.account.model.Account;
import com.ran.microservices.account.model.Customer;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

	private List<Account> accounts;
	
	@Autowired
    private RestTemplate restTemplate;
	public static final String customerServiceUrl = "http://CUSTOMER-SERVICE//";
	
	public AccountRepositoryImpl() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1, 1, "111","Saving"));
		accounts.add(new Account(2, 2, "222","FD"));
		accounts.add(new Account(3, 3, "333","Saving"));
		accounts.add(new Account(4, 4, "444","Recuring"));
		accounts.add(new Account(5, 1, "555","FD"));
		accounts.add(new Account(6, 2, "666","Recuring"));
		accounts.add(new Account(7, 2, "777","Saving"));
	}
	
	
	public Account findByNumber(String number) {
		return accounts.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
	}
	
	public List<Account> findByCustomer(Integer customerId) {
			return accounts.stream().filter(it -> it.getCustomerId().intValue()==customerId.intValue()).collect(Collectors.toList());
	}
	
	public List<Account> findByAccountType(String accountType){
		return accounts.stream().filter(it -> it.getAccountType().equals(accountType)).collect(Collectors.toList());
	}
	
	public List<Account> findAll() {
		return accounts;
	}
	
	public Account findById(@PathVariable("id") Integer id) {
		Account account = accounts.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
		Customer customer =  restTemplate.getForObject(customerServiceUrl + "/account/customer/{id}",Customer.class, id);
		account.setCustomer(customer);
		return account;
	}
}
