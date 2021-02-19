package com.revature.DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserDAOIMPTest {
		UserDAOIMP user = new UserDAOIMP();
	@Test
	void testLogIn() {
		assertTrue(user.logIn("TESTCUS@TEST.COM", "test") !=null);
	}

}
