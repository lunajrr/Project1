package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.TransactionDAOIMP;
import com.revature.model.Log4J2;
import com.revature.model.Transactions;

/**
 * Servlet implementation class ViewAllTransactionsServlet
 */
public class ViewAllTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllTransactionsServlet() {
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
		Log4J2.info("Tried to view all transactions");
		TransactionDAOIMP tranDAO = new TransactionDAOIMP();
		List<Transactions> tranList = tranDAO.getAllTransactions();
		request.getSession().setAttribute("transactions", tranList);
		request.getRequestDispatcher("viewAllTransactions.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
