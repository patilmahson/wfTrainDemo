package com.example.wftraining.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.wftraining.domains.Account;
import com.example.wftraining.domains.Customer;
import com.example.wftraining.domains.Transaction;

public interface AccountRepository extends MongoRepository<Account, ObjectId>{
	public Account findOneByid(Long id);
}
