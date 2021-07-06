package com.example.wftraining.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.wftraining.domains.Profile;



public interface ProfileRepository extends MongoRepository<Profile, Long> {
	
	Profile findByProfileId(long l);

	void deleteByProfileId(long id);
}
