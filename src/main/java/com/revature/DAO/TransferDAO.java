package com.revature.DAO;

import java.util.List;

import com.revature.model.Transfer;

public interface TransferDAO {
	
	public List<Transfer> seeAllTransfer(String accNumber);
	public boolean startTransfer(String sendAcc, String recAcc, double amount);
	public List<Transfer> seePendTransfer(String accNumber);
	public boolean decideTransfer(int tid, String decision);
}
