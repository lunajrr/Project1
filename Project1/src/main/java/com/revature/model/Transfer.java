package com.revature.model;

public class Transfer {
	
	private int tid;
	private double amount;
	private String rec_acc;
	private String send_acc;
	private String state;
	
	public Transfer() {}
	
	public Transfer(int tid, double amount, String rec_acc, String send_acc, String state) {
		super();
		this.tid = tid;
		this.amount = amount;
		this.rec_acc = rec_acc;
		this.send_acc = send_acc;
		this.state = state;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getRec_acc() {
		return rec_acc;
	}
	public void setRec_acc(String rec_acc) {
		this.rec_acc = rec_acc;
	}
	public String getSend_acc() {
		return send_acc;
	}
	public void setSend_acc(String send_acc) {
		this.send_acc = send_acc;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
