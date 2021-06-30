package com.example.wftraining.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {
	private Integer cID;
	private String firstName;
	private String lastName;
	private Integer age;
}
