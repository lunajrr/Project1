package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.AccountDAOIMP;
import com.revature.DAO.TransactionDAOIMP;
import com.revature.DAO.TransferDAOIMP;
import com.revature.model.Account;
import com.revature.model.Log4J2;
import com.revature.model.Transactions;
import com.revature.model.Transfer;



/**
 * Servlet implementation class CustomerViewAccountDetailsServlet
 */
public class CustomerViewAccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerViewAccountDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Log4J2.info("Tried access customer account details");
		// TODO Auto-generated method stub
		AccountDAOIMP accDAO = new AccountDAOIMP();
		TransactionDAOIMP tranDAO = new TransactionDAOIMP();
		TransferDAOIMP transferDAO = new TransferDAOIMP();
		String accNumber = request.getParameter("accNumber");
		Account acc = accDAO.getAccountByAccNumber(accNumber);
		List<Transactions> tranList = tranDAO.getTransactionByAccountNumber(accNumber);
		List<Transfer> transferList = transferDAO.seeAllTransfer(accNumber);
		
		request.getSession().setAttribute("account", acc);
		request.getSession().setAttribute("transactions", tranList);
		request.getSession().setAttribute("transfers", transferList);
		
		request.getRequestDispatcher("customerAccountView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
