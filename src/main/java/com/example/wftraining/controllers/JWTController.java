package com.example.wftraining.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wftraining.repositories.ProfileRepository;
import com.example.wftraining.security.CustomUserDetails;
import com.example.wftraining.security.CustomUserDetailsService;
import com.example.wftraining.security.jwt.JWTUtils;
import com.example.wftraining.security.requests.JWTResponse;
import com.example.wftraining.security.requests.LoginRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class JWTController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	ProfileRepository profileRepo;
	
	@Autowired
	JWTUtils jwtUtils;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		CustomUserDetails customUD = (CustomUserDetails) authentication.getPrincipal();
		
		return ResponseEntity.ok(new JWTResponse(
					jwt,
					customUD.getId(),
					customUD.getUsername(),
					customUD.getPassword(),
					null
				));
	}
}
