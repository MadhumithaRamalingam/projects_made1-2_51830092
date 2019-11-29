package com.bankapp.web.controller;

public class TransactionalRequest {
	
	private Long fromAccount;
	private Long toAccount;
	private double amount;
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public long getToAccount() {                                                                  
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransactionalRequest() {
		super();
	}
	
	

}
