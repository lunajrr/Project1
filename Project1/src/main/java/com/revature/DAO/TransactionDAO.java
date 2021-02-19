package com.revature.DAO;

import java.util.List;

import com.revature.model.Transactions;

public interface TransactionDAO {
	public List<Transactions> getTransactionByAccountNumber(String accNumber);
	public List<Transactions> getAllTransactions();
}
