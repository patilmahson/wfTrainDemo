package com.example.wftraining.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.wftraining.domains.ERole;
import com.example.wftraining.domains.Role;


public interface RoleRepository extends MongoRepository<Role, String> {
	Optional<Role> findByName(ERole name);
}
