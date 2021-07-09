package com.example.wftraining.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.wftraining.domains.User;

public interface UserRepository extends MongoRepository<User, Long>{

	Optional<User> findByUserName(String username);

	boolean existsByUserName(String username);

	boolean existsByEmail(String email);

}
