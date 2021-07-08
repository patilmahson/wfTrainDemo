package com.example.wftraining.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wftraining.controllers.ProfileController;
import com.example.wftraining.domains.Account;
import com.example.wftraining.domains.Customer;
import com.example.wftraining.domains.Profile;
import com.example.wftraining.domains.User;
import com.example.wftraining.error.ProfileNotFoundException;
import com.example.wftraining.repositories.ProfileRepository;


@Service
public class ProfileService {
	private final Logger LOGGER= org.slf4j.LoggerFactory.getLogger(ProfileService.class);

	@Autowired
	private ProfileRepository profileRepository;
	
	
	public Profile getProfile(long id) throws ProfileNotFoundException {
		LOGGER.info("inside getProfile of ProfileService");
		Profile profile = (Profile) this.profileRepository.findByProfileId(id);
		
		if(profile == null) {
			throw new ProfileNotFoundException("Profile not available");
		}
		
		return profile;
	}

	public void addProfile(Profile Profile) {
		this.profileRepository.save(Profile);
	}

	public void updateProfile(long id, Profile Profile) {
		this.profileRepository.save(Profile);
	}

	public void deleteProfile(long id) {
		this.profileRepository.deleteByProfileId(id);;
	}

	// for test only
	public  List<Profile> testProfiles() {
		//Profile pr = profileRepository.findByProfileId(1L);
		LOGGER.info("inside getProfiles of ProfileService");
			profileRepository.deleteAll();
	
		    final Account account = new Account(1L, "123", new Date(), "Saving", 10.0, 0);
		    final Account account2 = new Account(1L, "1234", new Date(), "Checking", 15.0, 0);
		    final Account account3 = new Account(1L, "12345", new Date(), "Credit Card", 16.0, 0);
		   
		    final User user = new User(1L,"1@1.com", "password", "john","doe");
		    final List<Account> accounts = Arrays.asList(account, account2, account3);
	
		    final Profile profile = new Profile(1L, user, "8054363453", 'y', accounts);
		    profileRepository.save(profile);
	
		    //Profile pro = profileRepository.findByProfileId(1L);
		    List<Profile> pros = profileRepository.findAll();
		    System.out.println("Find profiles");
		    for ( Profile pro: pros) {    	   
	
		    		System.out.println(pro);
		    }
	    
		return pros;
	}

	public List<Profile> getProfiles() {
		List<Profile> pros = profileRepository.findAll();
	    System.out.println("Find profiles");
	    for ( Profile pro: pros) {    	   

	    		System.out.println(pro);
	    }
		return pros;
	}
}
