package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.revature.model.*;




public class AccountDAOIMP implements AccountDAO{

	Connection conn = null;
	PreparedStatement stmt = null;
	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		Log4J2.info("Tried to get all accounts");
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select * from log_in_account_view order by username, account_number, state";
			stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Account acc = new Account();
				
				acc.setNumber(rs.getString(1));
				acc.setBalance(rs.getDouble(2));
				acc.setAcc_type(rs.getString(3));
				acc.setState(rs.getString(4));
				acc.setUsername(rs.getString(5));
				
				accounts.add(acc);
			}
			rs.close();
			
		}catch(SQLException e) {
			Log4J2.error("Could not get all accounts");
		}
		finally{
			closeResources();
		}
		return accounts;
	}
	
	
	@Override
	public List<Account> getAccountsByUser(String username) {
		// TODO Auto-generated method stub
		Log4J2.info("Tried get accounts from user: " + username);
		List<Account> accounts = new ArrayList<>();
		Log4J2.error("Could not get all accounts");
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select * from log_in_account_view where username =? order by account_number ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Account acc = new Account();
				
				acc.setNumber(rs.getString(1));
				acc.setBalance(rs.getDouble(2));
				acc.setAcc_type(rs.getString(3));
				acc.setState(rs.getString(4));
				acc.setUsername(rs.getString(5));
				
				accounts.add(acc);
			}
			rs.close();
			
		}catch(SQLException e) {
			Log4J2.error("Could not get accounts from user: " + username);
		}
		finally{
			closeResources();
		}
		
		return accounts;
	}
	
	@Override
	public Account getAccountByAccNumber(String accNumber) {
		// TODO Auto-generated method stub
		Log4J2.info("Tried search for account number: " + accNumber);
		Account acc = new Account();
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select * from accounts where account_number =?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, accNumber);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				acc.setNumber(rs.getString(2));
				acc.setBalance(rs.getDouble(3));
				acc.setAcc_type(rs.getString(4));
				acc.setState(rs.getString(5));
			}
			rs.close();
			
		}catch(SQLException e) {
			Log4J2.error("Failed to search for account number: " + accNumber);
		}
		finally{
			closeResources();
		}
		
		return acc;
	}
	
	@Override
	public List<Account> getAccountByState(String state) {
		// TODO Auto-generated method stub
		List<Account> accounts = new ArrayList<>();
		Log4J2.info("Tried to get account of states:  "+ state);
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select * from log_in_account_view where state=? order by username, account_number";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, state);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Account acc = new Account();
				
				acc.setNumber(rs.getString(1));
				acc.setBalance(rs.getDouble(2));
				acc.setAcc_type(rs.getString(3));
				acc.setState(rs.getString(4));
				acc.setUsername(rs.getString(5));
				
				accounts.add(acc);
			}
			rs.close();
			
		}catch(SQLException e) {
			Log4J2.error("Failed to get account of states:  "+ state);
		}
		finally{
			closeResources();
		}
		
		return accounts;
	}

	
	@Override
	public boolean withdraw(String accNumber, double amount) {
		// TODO Auto-generated method stub
		if(amount<=0 && amount>getBalance(accNumber)) {
			System.out.println("Invalid amount: either balance too low or amount too low");
			return false;}
		amount = Math.round(amount * 100.0) / 100.0;
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select withdraw(?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,accNumber);
			stmt.setDouble(2, amount);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			return rs.getBoolean(1);		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeResources();
		}
		
		return false;
	}
	
	
	@Override
	public boolean deposit(String accNumber, double amount) {
		// TODO Auto-generated method stub
		if(amount<0)
			return false;
		
		amount = Math.round(amount * 100.0) / 100.0;
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select deposit(?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,accNumber);
			stmt.setDouble(2, amount);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			return rs.getBoolean(1);		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeResources();
		}
		
		return false;
	}
	
	@Override
	public double getBalance(String accNumber) {
		Log4J2.info("Tried to get balance: " +accNumber);
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select balance from accounts where account_number = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,accNumber);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			return rs.getDouble(1);		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeResources();
		}
		
		return 0;
	}


	@Override
	public boolean decideAccount(String accNumber, String decision) {
		// TODO Auto-generated method stub
		Log4J2.info("Tried to decide a new account: " +accNumber);
		try {
			conn = DAOUtilities.getConnection();
			String sql ="update accounts set state =? where account_number=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, decision);
			stmt.setString(2,accNumber);
			
			
			stmt.execute();
			return true;		
		}catch(SQLException e) {
			Log4J2.error("Could not decide a new account: " +accNumber);
		}
		finally{
			closeResources();
		}
		
		return false;
	
	}


	@Override
	public boolean createNewAccount(User user, double amount, String type) {
		Log4J2.info("Tried to create a new account: " +user.getId());
		Random rnd = new Random();
		int firstHalf = rnd.nextInt(9999999);
		int secondHalf = rnd.nextInt(999999);
		String number = String.format("%07d%06d", firstHalf, secondHalf);
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select create_new_acc(?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user.getId());
			stmt.setString(2, number);
			stmt.setDouble(3, amount);
			stmt.setString(4, type);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) 
				return rs.getBoolean(1);

			rs.close();
			
		}catch(SQLException e) {
			Log4J2.error("Could not create a new account" + user.getId());
		}
		finally{
			closeResources();
		}
		
		return false;
	}
	
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

