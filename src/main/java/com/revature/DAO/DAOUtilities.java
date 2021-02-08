package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtilities {
	private static final String USER = "postgres";
	private static final String PASS = "a";
	private static final String URL = "jdbc:postgresql://localhost/bank";
	private static Connection connection;
	
	public static  Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Driver error");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, USER, PASS);
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			connection = DriverManager.getConnection(URL, USER, PASS);
		}
		return connection;
	}
	
}
