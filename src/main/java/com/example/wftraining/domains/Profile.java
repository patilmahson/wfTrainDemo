package com.example.wftraining.domains;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;

@Data
@Document(collection = "profiles")
public class Profile {
	
	@Id
	private long profileId;
	private User user;
	private String phoneNo;
	private char canEmail;
	private List<Account> acclist;
	
	 public Profile(
		      final long profileId,
		      final User user,
		      final String phoneNo,
		      final char canEmail,
		      final List<Account> acclist){
		    this.profileId = profileId;
		    this.user = user;
		    this.phoneNo = phoneNo;
		    this.canEmail = canEmail;
		    this.acclist = acclist;
		  
		  }

}
