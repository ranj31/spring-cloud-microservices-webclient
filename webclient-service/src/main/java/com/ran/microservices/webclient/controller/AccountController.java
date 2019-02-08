/**
 * 
 */
package com.ran.microservices.webclient.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ran.microservices.webclient.repository.AccountRepository;

@Controller
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	protected Logger logger = Logger.getLogger(AccountController.class.getName());
	
	@RequestMapping("/")
	public String home(){
		logger.info(String.format("AccountController.home()"));
		return "index";
	}
	@RequestMapping("/accountList")
	public String findAll(Model model) {
		logger.info(String.format("AccountController.findAll()"));
		model.addAttribute("accounts", accountRepository.findAll());
		return "accountList";
	}
	
	@RequestMapping("/accountDetails")
	public String findById(@RequestParam("id") Integer id, Model model) {
		logger.info(String.format("AccountController.findById(%s)", id));
		model.addAttribute("account", accountRepository.findById(id));
		return "accountDetails";
	}
	
	@RequestMapping("/accountDetails/number")
	public String findByNumber(@RequestParam("number") String number, Model model) {
		logger.info(String.format("AccountController.findByNumber(%s)", number));
		model.addAttribute("account", accountRepository.findByNumber(number));
		return "accountDetails";
	}
	
	@RequestMapping("/accountDetails/accountType")
	public String findByAccountType(@RequestParam("accountType") String accountType, Model model) {
		logger.info(String.format("AccountController.findByAccountType(%s)", accountType));
		model.addAttribute("account", accountRepository.findByAccountType(accountType));
		return "accountDetails";
	}
}
