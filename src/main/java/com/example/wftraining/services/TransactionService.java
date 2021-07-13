package com.example.wftraining.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wftraining.domains.Customer;
import com.example.wftraining.domains.Transaction;
import com.example.wftraining.domains.TransactionEvent;
import com.example.wftraining.producers.TransactionEventsProducer;
import com.example.wftraining.repositories.CustomerRepository;
import com.example.wftraining.repositories.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository tr;
	
	@Autowired
	TransactionEventsProducer tep;
	
	public void addTransaction(Transaction transaction) throws JsonProcessingException {
		tr.save(transaction);
		tep.createTransactionEvent(new TransactionEvent("post", Integer.valueOf(0), transaction));
	}

	public List<Transaction> listTransactionsByAccountID(long accountID){
		return tr.findByAccountID(accountID);
	}
}
