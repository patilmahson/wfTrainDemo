package com.example.wftraining.domains;

public enum AccountType {
SAVING("Saving"),
CHECKING("Checking"),
CREDIT_CARD("Credit Card");
	
private final String value;
AccountType(String value) {
	this.value = value;	
}

private String value() {
	return value;
}

}
