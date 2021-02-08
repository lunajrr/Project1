package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Log4J2;
import com.revature.model.Transactions;

public class TransactionDAOIMP implements TransactionDAO {
	Connection conn= null;
	PreparedStatement stmt =null;
	
	@Override
	public List<Transactions> getTransactionByAccountNumber(String accNumber) {
		// TODO Auto-generated method stub
		List<Transactions> tran = new ArrayList<>();
		Log4J2.info("Tried to get all transactions by account number: "+accNumber);
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select * from transactions where acc_number = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, accNumber);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Transactions transaction = new Transactions();
				
				transaction.setTid(rs.getInt(1));
				transaction.setAcc_number(rs.getString(2));
				transaction.setAmount(rs.getDouble(3));
				transaction.setType(rs.getString(4));
				transaction.setDescription(rs.getString(5));
				transaction.setTime(rs.getString(6));
				
				tran.add(transaction);
			}
			rs.close();
			
		}catch(SQLException e) {
			Log4J2.error("Tried to get all transactions by account number: "+accNumber);
		}
		finally{
			closeResources();
		}
		
		return tran;
	}
	
	
	@Override
	public List<Transactions> getAllTransactions() {
		// TODO Auto-generated method stub
		List<Transactions> tran = new ArrayList<>();
		Log4J2.info("Tried to get all transactions");
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select * from transactions";
			stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Transactions transaction = new Transactions();
				
				transaction.setTid(rs.getInt(1));
				transaction.setAcc_number(rs.getString(2));
				transaction.setAmount(rs.getDouble(3));
				transaction.setType(rs.getString(4));
				transaction.setDescription(rs.getString(5));
				transaction.setTime(rs.getString(6));
				
				tran.add(transaction);
			}
			rs.close();
			
		}catch(SQLException e) {
			Log4J2.error("Failed to get all transactions  ");
		}
		finally{
			closeResources();
		}
		
		return tran;
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
