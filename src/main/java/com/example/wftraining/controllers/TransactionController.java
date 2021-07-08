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
import com.example.wftraining.services.TransactionService;

@RestController
@RequestMapping("transactions")
public class TransactionController {
	@Autowired
	TransactionService ts;
	
	@RequestMapping(method=RequestMethod.POST)
	public String addTransaction(@RequestBody Transaction transaction) {
		transaction.setDate(LocalDateTime.now());
		ts.addTransaction(transaction);
		String response = "{\"success\": true, \"message\": Transaction has been added successfully.}";
		return response;
	}
	
	@GetMapping("/{accountID}")
	public List<Transaction> getTransactions(@PathVariable Long accountID){
		//TODO: specify which transactions to return by profileID or accountID
		return ts.listTransactionsByAccountID(accountID);
		
	}
	
}
