package com.example.wftraining.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.wftraining.domains.Transaction;
import com.example.wftraining.services.RedemptionService;
import com.example.wftraining.services.TransactionService;

@RestController
@RequestMapping("accounts")
public class RewardController {
	@Autowired
	RedemptionService rs;
	
	@RequestMapping(method=RequestMethod.PUT, value="/{accountID}/{points}")
	public String redeemPoints(@PathVariable long accountID, @PathVariable long points) {
		//TODO: store point redemption transactions
		rs.redeemPoints(accountID, points);
		String response = "{\"success\": true, \"message\": " + points + " have been redeemed successfully.}";
		return response;
	}
	
}
