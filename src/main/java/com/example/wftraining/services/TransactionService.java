package com.example.wftraining.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wftraining.domains.Customer;
import com.example.wftraining.domains.Transaction;
import com.example.wftraining.repositories.CustomerRepository;
import com.example.wftraining.repositories.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository tr;
	
	public void addTransaction(Transaction transaction) {
		tr.save(transaction);
	}

	public List<Transaction> listTransactionsByAccountID(long accountID){
		return tr.findByAccountID(accountID);
	}
}
