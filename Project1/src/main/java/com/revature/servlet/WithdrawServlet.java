package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.AccountDAOIMP;
import com.revature.model.Log4J2;

/**
 * Servlet implementation class WithdrawServlet
 */
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Log4J2.info("Tried to withdraw money");
		AccountDAOIMP accDAO = new AccountDAOIMP();
		try {
		String accNum = request.getParameter("accNumber");
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		
		
		if(accDAO.withdraw(accNum, amount)) {
			request.getSession().setAttribute("error", null);
			request.getRequestDispatcher("customerViewAccountDetails").forward(request, response);
		}
		else 
			request.getSession().setAttribute("error", "CANNOT DEPOSIT");
		}
		catch(Exception e) {
		request.getSession().setAttribute("error", "CANNOT DEPOSIT");
	}}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
