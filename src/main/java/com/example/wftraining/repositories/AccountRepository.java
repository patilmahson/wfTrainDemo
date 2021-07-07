package com.example.wftraining.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.wftraining.domains.Account;

public interface AccountRepository extends MongoRepository<Account, Long>{

	Account findById(String id);
	void deleteById(String id);
}
