package com.example.wftraining.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wftraining.domains.Account;
import com.example.wftraining.services.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/Accounts")
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/Accounts/{id}")
	public Account getAccount(@PathVariable String id) {
		return accountService.getAccount(id);
	}
	
	@PostMapping("/Accounts")
	public String addAccount(Account account) {
		accountService.addAccount(account);
		String response = "{\"success\": true, \"message\": Account has been added successfully.}";
		return response;
	}
	
	@PutMapping("/Accounts/{id}")
	public String updateAccount(@RequestBody Account account, @PathVariable String id) {
		accountService.updateAccount(id, account);
		String response = "{\"success\": true, \"message\": Account has been updated successfully}";
		return response;
	}
	
	@DeleteMapping("/Accounts/{id}")
	public String deleteAccount(@PathVariable String id) {
		accountService.deleteAccount(id);
		String response = "{\"success\": true, \"message\": Account has been deleted successfully.}";
		return response;
	}
}
