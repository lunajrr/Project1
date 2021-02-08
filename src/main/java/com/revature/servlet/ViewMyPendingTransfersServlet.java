package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.AccountDAOIMP;
import com.revature.DAO.TransferDAOIMP;
import com.revature.model.Account;
import com.revature.model.Log4J2;
import com.revature.model.Transfer;
import com.revature.model.User;

/**
 * Servlet implementation class ViewMyPendingTransfersServlet
 */
public class ViewMyPendingTransfersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMyPendingTransfersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Log4J2.info("Tried to view my pending transfers");
		
		TransferDAOIMP transferDAO = new TransferDAOIMP();
		AccountDAOIMP accDAO = new AccountDAOIMP();
		User user = (User) request.getSession().getAttribute("User");
		List<Account> accList = accDAO.getAccountsByUser(user.getUsername());
		List<Transfer> tranList = new ArrayList<Transfer>();
		
		for(Account acc: accList)
			tranList.addAll(transferDAO.seePendTransfer(acc.getNumber()));
		
		request.getSession().setAttribute("pendingTransfer", tranList);
		
		request.getRequestDispatcher("viewPendingTransfers.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
