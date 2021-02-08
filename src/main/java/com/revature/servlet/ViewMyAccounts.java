package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.AccountDAOIMP;
import com.revature.model.Account;
import com.revature.model.Log4J2;
import com.revature.model.User;

/**
 * Servlet implementation class ViewMyAccounts
 */
public class ViewMyAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMyAccounts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Log4J2.info("Tried to view my accounts");
		AccountDAOIMP accDAO = new AccountDAOIMP();
		User user = (User) request.getSession().getAttribute("User");
		String username = user.getUsername();
		List<Account> accList =accDAO.getAccountsByUser(username);
		
		request.getSession().setAttribute("accounts", accList);
		
		request.getRequestDispatcher("customerAllAccountsView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
