package com.revature.model;

public class User {

	private String username;
	private Boolean employee;
	private String firstName;
	private String lastName;
	private int id;
	private String password;
	
	public void setPassword(String pass) {
		this.password=pass;
	}
	public String getPassword() {
		return this.password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getEmployee() {
		return employee;
	}
	public void setEmployee(Boolean employee) {
		this.employee = employee;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User() {
		super();
	}
	public User(String username, Boolean employee, String firstName, String lastName, int id, String password) {
		super();
		this.username = username;
		this.employee = employee;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.password = password;
	}
	
}
