package com.ran.microservices.webclient.repository;

import java.util.Arrays;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.ran.microservices.webclient.Model.Account;

public class RemoteAccountRepository implements AccountRepository {
	
	@Autowired
	protected RestTemplate restTemplate;
	protected Logger logger = Logger.getLogger(RemoteAccountRepository.class.getName());
	
	protected String accountServiceUrl;
	
	public RemoteAccountRepository(String accountServiceUrl) {
		this.accountServiceUrl = accountServiceUrl.startsWith("http") ? accountServiceUrl
				: "http://" + accountServiceUrl;
	}
	
	@Override
	public List<Account> findAll() {
		Account[] accounts = restTemplate.getForObject(accountServiceUrl+"/accounts", Account[].class);
		return Arrays.asList(accounts);
	}

	@Override
	public Account findById(Integer id) {
		return restTemplate.getForObject(accountServiceUrl + "/accounts/{id}",	Account.class, id);
	}
	
	@Override
	public Account findByNumber(String number) {
		return restTemplate.getForObject(accountServiceUrl + "/accounts/number/{number}",	Account.class, number);
	}
	
	@Override
	public Account findByAccountType(String accountType) {
		Account[] accounts = restTemplate.getForObject(accountServiceUrl + "/accounts/accounttype/{accounttype}",	Account[].class, accountType);
		return accounts[0];
	}
}
