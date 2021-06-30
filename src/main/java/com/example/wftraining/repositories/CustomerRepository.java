package com.example.wftraining.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.wftraining.domains.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByFirstName(String firstName);
	public List<Customer> findByLastName(String lastName);
	public Customer findBycID(Integer integer);

}
