package com.revature.model;

public class Account {
	
	private String acc_type;
	private String state;
	private String username;
	private String number;
	private double balance;

	public Account() {
	
	}
public String getAcc_type() {
		return acc_type;
	}


	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		balance = Math.round(balance * 100.0) / 100.0;
		this.balance = balance;
	}


public Account(String number, double balance, String acc_type, String state, String username ) {
		super();
		balance = Math.round(balance * 100.0) / 100.0;
		this.acc_type = acc_type;
		this.state = state;
		this.username = username;
		this.number = number;
		this.balance = balance;
	}









}
