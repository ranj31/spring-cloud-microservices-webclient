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

import com.ran.microservices.webclient.repository.CustomerRepository;

@Controller
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;
	protected Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	@RequestMapping("/customerList")
	public String customerList(Model model) {
		logger.info(String.format("CustomerController.customerList"));
		model.addAttribute("customers", customerRepository.findAll());
		return "customerList";
	}
	
	@RequestMapping("/customerDetails")
	public String findByID(@RequestParam("id") Integer id, Model model) {
		logger.info(String.format("CustomerController.findByID(%s)", id));
		model.addAttribute("customer", customerRepository.findById(id));
		return "customerDetails";
	}
	
	@RequestMapping("/customerDetails/aadhar")
	public String findByAadhar(@RequestParam("aadhar") String aadhar, Model model) {
		logger.info(String.format("CustomerController.findByAadhar(%s)", aadhar));
		model.addAttribute("customer", customerRepository.findByAadhar(aadhar));
		return "customerDetails";
	}
}
