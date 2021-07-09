package com.example.wftraining.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Document(collection = "roles")
@Data
public class Role {
	@Id
	private String id;
	private ERole name;
	
	public Role(ERole name) {
		this.name = name;
	}
}
