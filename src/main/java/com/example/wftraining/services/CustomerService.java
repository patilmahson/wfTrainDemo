package com.example.wftraining.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wftraining.domains.Customer;
import com.example.wftraining.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository cr;
	
	public void createCustomer(Customer c) {
		cr.save(c);
	}

	public List<Customer> findCustomers() {
		return cr.findAll();
	}

	public void updateCustomer(Customer customer) {
		Customer foundCustomer = cr.findBycID(customer.getCID());
		if(Objects.isNull(foundCustomer)) {
		cr.save(customer);
		}
	}
}
