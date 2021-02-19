package com.revature.DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransactionDAOIMPTest {
	TransactionDAOIMP trandDAO = new TransactionDAOIMP();
	@Test
	void testGetTransactionByAccountNumber() {
		assertTrue(trandDAO.getTransactionByAccountNumber("0128067763418").size()>0);
	}

	@Test
	void testGetAllTransactions() {
		assertTrue(trandDAO.getAllTransactions().size() >0);
	}

}
