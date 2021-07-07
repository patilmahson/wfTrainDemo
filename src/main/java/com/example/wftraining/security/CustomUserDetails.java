package com.example.wftraining.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.wftraining.domains.Profile;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Profile profile;
	private long id;
	
	public CustomUserDetails(Profile profile) {
		this.profile = profile;
		this.id = profile.getProfileId();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getId() {
		return id;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return profile.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return Long.toString(profile.getUserId());
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
