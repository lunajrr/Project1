package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Log4J2;
import com.revature.model.User;

public class UserDAOIMP implements UserDAO{
	Connection conn = null;
	PreparedStatement stmt = null;
	@Override
	public User logIn(String username, String pass) {
		// TODO Auto-generated method stub
		User user = new User();
		Log4J2.info("Tried to log in: " +username + "password: "+pass);
		try {
			conn = DAOUtilities.getConnection();
			String sql ="select * from log_info where username =? and password =?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, pass);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				user.setEmployee(rs.getBoolean(6));
				user.setFirstName(rs.getString(4));
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setLastName(rs.getString(5));
		
			}
			rs.close();
			
		}catch(SQLException e) {
			Log4J2.error("Failed to log in: " +username + "password: "+pass);
		}
		finally{
			closeResources();
		}
		
		return user;
	}
		

	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		try {
			Log4J2.info("Tried to log in: " +user.getId());
			conn = DAOUtilities.getConnection();
			String sql ="insert into log_info(id, username, password, first_name, last_name, employee) VALUES (?, ?, ?, ?, ?, ?);";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getFirstName());
			stmt.setString(5, user.getLastName());
			stmt.setBoolean(6, user.getEmployee());
		
			stmt.execute();
			return true;
			
		}catch(SQLException e) {
			Log4J2.error("Duplicate Logs: " +user.getUsername() + " password: "+ user.getPassword());
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
