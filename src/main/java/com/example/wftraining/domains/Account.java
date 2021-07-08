package com.example.wftraining.domains;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Account {
@Id
private long id;	
private String accNo;
private Date expDate;
private String accType;
private double balance;
private long rewardPoints;
}
