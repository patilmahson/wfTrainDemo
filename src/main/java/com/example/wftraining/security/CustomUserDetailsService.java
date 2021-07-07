package com.example.wftraining.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.wftraining.domains.Profile;
import com.example.wftraining.repositories.ProfileRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ProfileRepository profileRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Profile profile = profileRepo.findByUserId(username);
		if (profile == null){
			throw new UsernameNotFoundException("User Id not found");
		}
		return new CustomUserDetails(profile);
	}

}
