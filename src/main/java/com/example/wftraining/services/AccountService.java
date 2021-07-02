package com.example.wftraining.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wftraining.domains.Account;
import com.example.wftraining.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepo;
	
	@SuppressWarnings("null")
	private List<Account> Accounts = new ArrayList<>(Arrays.asList(
			new Account("123",  (Double) null),
			new Account("456", (Double) null),
			new Account("789",  (Double) null)
			));
	
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return (List<Account>) this.accountRepo.findAll();
	}

	public Account getAccount(String id) {
		// TODO Auto-generated method stub
		return (Account) this.accountRepo.findById(id);
	}

	public void updateAccount(String id, Account account) {
		// TODO Auto-generated method stub
		this.accountRepo.save(account);
	}

	public void deleteAccount(String id) {
		// TODO Auto-generated method stub
		this.accountRepo.deleteById(id);
	}

	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		this.accountRepo.save(account);
	}
}
