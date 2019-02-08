package com.ran.microservices.account.api;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ran.microservices.account.model.Account;
import com.ran.microservices.account.repository.AccountRepository;


@RestController
public class AccountApi {

	@Autowired
	AccountRepository accountRepository;
	protected Logger logger = Logger.getLogger(AccountApi.class.getName());
	
	public AccountApi() {
	}
	
	@RequestMapping("/accounts/number/{number}")
	public Account findByNumber(@PathVariable("number") String number) {
		logger.info(String.format("Account.findByNumber(%s)", number));
		return accountRepository.findByNumber(number);	
	}
	
	@RequestMapping("/accounts/customer/{customer}")
	public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
		logger.info(String.format("Account.findByCustomer(%s)", customerId));
		return accountRepository.findByCustomer(customerId);
	}
	
	@RequestMapping("/accounts/accounttype/{accountType}")
	public List<Account> findByAccountType(@PathVariable("accountType")String accountType){
		logger.info(String.format("Account.findByAccountType(%s)", accountType));
		return accountRepository.findByAccountType(accountType);
	}
	
	@RequestMapping("/accounts")
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		return accountRepository.findAll();
	}
	
	@RequestMapping("/accounts/{id}")
	public Account findById(@PathVariable("id") Integer id) {
		logger.info(String.format("RestTemplate called ..Account->Customer.findById(%s)", id));
		return accountRepository.findById(id);
	}
	
}
