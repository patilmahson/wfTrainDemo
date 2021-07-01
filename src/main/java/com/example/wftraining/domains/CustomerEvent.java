package com.example.wftraining.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerEvent {
	private String customerEventType;
	private Integer customerEventID;
	private Customer customer;
}
