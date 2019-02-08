/**
 * 
 */
package com.ran.microservices.webclient.repository;

import java.util.List;

import com.ran.microservices.webclient.Model.Account;

public interface AccountRepository {
	List<Account> findAll();
	Account findById(Integer id);
	Account findByNumber(String number);
	Account findByAccountType(String accounttype);
}
