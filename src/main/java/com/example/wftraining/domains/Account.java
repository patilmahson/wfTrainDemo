package com.example.wftraining.domains;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Account {

private long id;	
private String accNo;
private Date expDate;
private String accType;
private double balance;
}
