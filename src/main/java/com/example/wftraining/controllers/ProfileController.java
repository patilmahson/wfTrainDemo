package com.example.wftraining.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.wftraining.domains.Profile;
import com.example.wftraining.error.ProfileNotFoundException;
import com.example.wftraining.services.ProfileService;


@RestController
public class ProfileController {
	private final Logger LOGGER= org.slf4j.LoggerFactory.getLogger(ProfileController.class);

	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/")
	public  List<Profile> getProfiles() {
		LOGGER.info("inside getProfiles of controller");
		return profileService.getProfiles();
	}
		
	@RequestMapping("/Profiles/{id}")
	public Profile getProfile(@PathVariable long id) throws ProfileNotFoundException {
		return profileService.getProfile(id);
	}
	
	//@PostMapping("/Profiles")
	@RequestMapping(method=RequestMethod.POST, value="/Profiles")
	public String addProfile(@RequestBody Profile Profile) {
		profileService.addProfile(Profile);
		String response = "{\"success\": true, \"message\": Profile has been added successfully.}";
		return response;
	}
	
	//@RequestMapping(method=RequestMethod.PUT, value="/Profiles/{id}")
	@PutMapping("/Profiles/{id}")
	public String updateProfile(@RequestBody Profile Profile, @PathVariable long id) {
		profileService.updateProfile(id, Profile);
		String response = "{\"success\": true, \"message\": Profile has been updated successfully.}";
		return response;
	}
	
	//@RequestMapping(method=RequestMethod.DELETE, value="/Profiles/{id}")
	@DeleteMapping("/Profiles/{id}")
	public String deleteProfile(@PathVariable long id) {
		profileService.deleteProfile(id);
		String response = "{\"success\": true, \"message\": Profile has been deleted successfully.}";
		return response;
	}
}
