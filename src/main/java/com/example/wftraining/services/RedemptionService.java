package com.example.wftraining.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wftraining.domains.Account;
import com.example.wftraining.repositories.AccountRepository;

@Service
public class RedemptionService {

	@Autowired
	AccountRepository ar;
	
	public void redeemPoints(Long accountID, long points) {
		Account ac = ar.findOneByid(accountID);
		ac.setRewardPoints(ac.getRewardPoints() - points);
		ar.save(ac);
	}

}
