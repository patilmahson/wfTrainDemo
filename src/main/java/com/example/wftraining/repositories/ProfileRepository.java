package com.example.wftraining.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.wftraining.domains.Profile;

public interface ProfileRepository extends MongoRepository<Profile, String>{

	public Profile findByUserId(String username);

}
