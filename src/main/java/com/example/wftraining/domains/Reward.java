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
@Document(collection = "rewards")
public class Reward {
	@Id
	private ObjectId id;
	private Long pointsToRedeem;
	private LocalDateTime date;
	private String category;
	private String name;
	private String description;
	//TODO: directory of thumbnail
}
