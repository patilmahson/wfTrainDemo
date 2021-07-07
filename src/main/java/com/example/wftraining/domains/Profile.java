package com.example.wftraining.domains;

import java.util.List;

import lombok.Data;

@Data
public class Profile {

	private long profileId;
	private long userId;
	private String password;
	private String phoneNo;
	private char canEmail;
	private List<Account> acclist;
	
	public Profile(long l, User user, String string, char c, List<Account> accounts) {
		// TODO Auto-generated constructor stub
		this.profileId = l;
		this.userId = user.getId();
		this.password = string;
		this.canEmail = c;
		this.acclist = accounts;
	}
}
