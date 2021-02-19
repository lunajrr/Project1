package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Log4J2;
import com.revature.model.Transfer;

public class TransferDAOIMP implements TransferDAO {
	Connection conn;
	PreparedStatement stmt;
	
	@Override
	public List<Transfer> seeAllTransfer(String accNumber) {
		// TODO Auto-generated method stub
		Log4J2.info("Tried see transfers for: " + accNumber);
		List<Transfer> tran = new ArrayList<>();
		
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select * from transfers where send_acc = ? or rec_acc = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, accNumber);
			stmt.setString(2, accNumber);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Transfer transfer = new Transfer();
				
				transfer.setTid(rs.getInt(1));
				transfer.setAmount(rs.getDouble(2));
				transfer.setRec_acc(rs.getString(3));
				transfer.setSend_acc(rs.getString(4));
				transfer.setState(rs.getString(5));
				
				tran.add(transfer);
			}
			rs.close();
			
		}catch(SQLException e) {
			Log4J2.error("Failed to see transfers for: " + accNumber);
		}
		finally{
			closeResources();
		}
		
		return tran;
	}

	@Override
	public boolean startTransfer(String sendAcc, String recAcc, double amount) {
		// TODO Auto-generated method stub
		Log4J2.info("Tried to start transfers for: " + sendAcc + " to "+ recAcc+ " amount: "+amount );
		boolean result = false;
		amount = Math.round(amount * 100.0) / 100.0;
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select start_transfer(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, sendAcc);
			stmt.setString(2, recAcc);
			stmt.setDouble(3, amount);

			ResultSet rs = stmt.executeQuery();
			rs.next();
			result= rs.getBoolean(1);
			rs.close();
			
		}catch(SQLException e) {
			Log4J2.error("Failed to start transfers for: " + sendAcc + " to "+ recAcc+ " amount: "+amount );
		}
		finally{
			closeResources();
		}
		
		return result;
	}

	@Override
	public List<Transfer> seePendTransfer(String accNumber) {
		// TODO Auto-generated method stub
		Log4J2.info("Tried to see pending transfers "+accNumber);
		List<Transfer> tran = new ArrayList<>();
		String p = "P";
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select * from transfers where rec_acc = ? and state= ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, accNumber);
			stmt.setString(2, p);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Transfer transfer = new Transfer();
				
				transfer.setTid(rs.getInt(1));
				transfer.setAmount(rs.getDouble(2));
				transfer.setRec_acc(rs.getString(3));
				transfer.setSend_acc(rs.getString(4));
				transfer.setState(rs.getString(5));
				
				tran.add(transfer);
			}
			rs.close();
			
		}catch(SQLException e) {
			Log4J2.error("Failed to see pending transfers "+accNumber);
		}
		finally{
			closeResources();
		}
		
		return tran;
	}
	

	@Override
	public boolean decideTransfer(int tid, String decision) {
		// TODO Auto-generated method stub
		Log4J2.info("Tried to decide transfers "+ tid);
		try {
			conn = DAOUtilities.getConnection();
			String sql ="update transfers set state = ? where tid = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(2, tid);
			stmt.setString(1, decision);
			stmt.execute();
			return true;
			
		}catch(SQLException e) {
			Log4J2.error("Failed to decide transfers "+ tid);
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
