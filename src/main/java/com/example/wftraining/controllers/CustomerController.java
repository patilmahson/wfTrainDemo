package com.example.wftraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wftraining.domains.Customer;
import com.example.wftraining.services.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CustomerController {
	@Autowired
	CustomerService cs;
	
	@PostMapping("/customers")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) throws JsonProcessingException{
		cs.createCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}
}
