package com.example.wftraining.domains;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "transactions")
public class Transaction {
	@Id
	private ObjectId id;
	private Long amount;
	private LocalDateTime date;
	private String category;
	private String merchantName;
	private String description;
	private Long accountID;
}
