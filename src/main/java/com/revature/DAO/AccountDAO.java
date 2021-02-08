package com.revature.DAO;

import java.util.List;

import com.revature.model.*;

public interface AccountDAO {
	
	
	public List<Account> getAllAccounts();
	public List<Account> getAccountsByUser(String username);
	public Account getAccountByAccNumber(String accNumber);
	public List<Account> getAccountByState(String state);
	
	public boolean withdraw(String accNumber, double amount);
	public boolean deposit(String accNumber, double amount);
	public double getBalance(String accNumber);
	public boolean decideAccount(String accNumber, String decision);
	public boolean createNewAccount(User user, double amount, String type );
	
	
}
