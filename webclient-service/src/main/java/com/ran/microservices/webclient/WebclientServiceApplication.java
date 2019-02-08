package com.ran.microservices.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.ran.microservices.webclient.repository.AccountRepository;
import com.ran.microservices.webclient.repository.CustomerRepository;
import com.ran.microservices.webclient.repository.RemoteAccountRepository;
import com.ran.microservices.webclient.repository.RemoteCustomerRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class WebclientServiceApplication {
	public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNT-SERVICE";
	public static final String CUSTOMERS_SERVICE_URL = "http://CUSTOMER-SERVICE";

	public static void main(String[] args) {
		SpringApplication.run(WebclientServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public AccountRepository accountRepository(){
		return new RemoteAccountRepository(ACCOUNTS_SERVICE_URL);
	}
	
	@Bean
	public CustomerRepository customerRepository(){
		return new RemoteCustomerRepository(CUSTOMERS_SERVICE_URL);
	}

}

