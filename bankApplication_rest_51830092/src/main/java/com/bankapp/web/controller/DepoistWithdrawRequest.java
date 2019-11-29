package com.bankapp.web.controller;

public class DepoistWithdrawRequest {
	private Long accountNumber;
	private double amount;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public DepoistWithdrawRequest() {
		super();
	}
	

}
