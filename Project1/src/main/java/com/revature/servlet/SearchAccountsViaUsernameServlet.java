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

/**
 * Servlet implementation class SearchAccountsViaUsernameServlet
 */
public class SearchAccountsViaUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccountsViaUsernameServlet() {
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
		Log4J2.info("Tried to search accounts via username");
		AccountDAOIMP accDAO = new AccountDAOIMP();
		if(request.getParameter("username")!=null) {
		String username = request.getParameter("username").toUpperCase();
		List<Account> accList = accDAO.getAccountsByUser(username);
		
		
		request.getSession().setAttribute("searchedAccs", accList);
		request.getSession().setAttribute("searchedUser", username);
		response.sendRedirect("searchUser.jsp?username="+username);}
	
	else {
		request.getSession().setAttribute("searchedAccs", null);
		request.getSession().setAttribute("searchedUser", null);
		request.getRequestDispatcher("searchUser.jsp").forward(request, response);
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
