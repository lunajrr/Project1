package com.revature.DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountDAOIMPTest {

		AccountDAOIMP accDAO = new AccountDAOIMP();

		
		@Test
		void testGetAllAccounts() {
			assertTrue(accDAO.getAllAccounts() !=null); 
		}

		@Test
		void testGetAccountsByUser() {
			assertTrue(accDAO.getAccountsByUser("TESTCUS@TEST.COM") !=null); 
		}

		@Test
		void testGetAccountByAccNumber() {
			assertTrue(accDAO.getAccountByAccNumber("0128067763418") !=null); 
		}

		@Test
		void testGetAccountByState() {
			assertTrue(accDAO.getAccountByState("P") !=null); 
		}

		@Test
		void testWithdraw() {
			assertTrue(accDAO.withdraw("0128067763418", 5)); 
		}

		@Test
		void testDeposit() {
			assertTrue(accDAO.deposit("0128067763418", 5)); 
		}

		@Test
		void testGetBalance() {
			assertTrue(accDAO.getBalance("0128067763418") >=0); 
		}

	}



