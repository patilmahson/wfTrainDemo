package com.example.wftraining.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionEvent {
	private String transactionEventType;
	private Integer transactionEventID;
	private Transaction transaction;
}
