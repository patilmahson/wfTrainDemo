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
}
