package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.AccountDAOIMP;
import com.revature.model.Log4J2;
import com.revature.model.User;



/**
 * Servlet implementation class CreateNewAccountServlet
 */
public class CreateNewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAccountServlet() {
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
		Log4J2.info("Tried to create a new account");
		User user = (User) request.getSession().getAttribute("User");
		try {
		double balance = Double.parseDouble(request.getParameter("balance"));
		String type = request.getParameter("type");
		AccountDAOIMP accDAO = new AccountDAOIMP();
		if(accDAO.createNewAccount(user, balance, type)) {
			request.getSession().setAttribute("created", "Account Created!");
			request.getRequestDispatcher("createNewAccount.jsp").forward(request, response);
		}
		else {
			request.getSession().setAttribute("created", "Could not create Account!");
			request.getRequestDispatcher("createNewAccount.jsp").forward(request, response);
		}
		
		
		}catch (Exception e) {
		System.out.println("COuldn't get balance");}
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
