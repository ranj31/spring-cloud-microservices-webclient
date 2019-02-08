package com.ran.microservices.account.repository;

import java.util.List;

import com.ran.microservices.account.model.Account;

public interface AccountRepository {
	public Account findByNumber(String number);
	public List<Account> findByCustomer(Integer customerId);
	public List<Account> findAll();
	public Account findById(Integer id);
	public List<Account> findByAccountType(String accountType);
}
