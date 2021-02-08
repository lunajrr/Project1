package com.revature.DAO;

import com.revature.model.User;

public interface UserDAO {

	
	public User logIn(String username, String pass);
	public boolean createUser(User user);
	
}
