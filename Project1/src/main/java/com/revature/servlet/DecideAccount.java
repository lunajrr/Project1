package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.AccountDAOIMP;
import com.revature.model.Log4J2;

/**
 * Servlet implementation class DecideAccount
 */
public class DecideAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecideAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("User")==null)
			response.sendRedirect("logIn.jsp");
		Log4J2.info("Tried to decide an account");
		AccountDAOIMP accDAO = new AccountDAOIMP();
		String accNumber = request.getParameter("accNumber");
		String decision = request.getParameter("decision");
		if(accDAO.decideAccount(accNumber, decision)) {
			request.getSession().setAttribute("success", "Account updated");
		}
		else {
			request.getSession().setAttribute("success", "Account failed updating");
		}
		request.getRequestDispatcher("viewPendingAccounts").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
