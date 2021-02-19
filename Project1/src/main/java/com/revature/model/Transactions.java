package com.revature.model;

public class Transactions {

	private int tid;
	private String acc_number;
	private double amount;
	private String type;
	private String description;
	private String time;
	public Transactions() {}
	public Transactions(int tid, String acc_number, double amount, String type, String description, String time) {
		super();
		this.tid = tid;
		this.acc_number = acc_number;
		this.amount = amount;
		this.type = type;
		this.description = description;
		this.time = time;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getAcc_number() {
		return acc_number;
	}
	public void setAcc_number(String acc_number) {
		this.acc_number = acc_number;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		amount = Math.round(amount * 100.0) / 100.0;
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
