package com.revature.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.UserDAOIMP;
import com.revature.model.Log4J2;
import com.revature.model.User;

/**
 * Servlet implementation class CreateNewUserServlet
 */
public class CreateNewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Log4J2.info("Creating a new user");
		Random rnd = new Random();
		//gotta change db to make it generate id numbers automatically
		int id = rnd.nextInt(100000);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		User user = new User();
		user.setEmployee(false);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setId(id);
		user.setPassword(password);
		user.setUsername(username.toUpperCase());
		UserDAOIMP userIMP = new UserDAOIMP();
		if(userIMP.createUser(user)) {
			request.getSession().setAttribute("success", null);
			request.getSession().setAttribute("User", user);
			request.getRequestDispatcher("customer.jsp").forward(request, response);}
		
		else {
		request.getSession().setAttribute("success", "Couldn't Create Account");
		request.getRequestDispatcher("logIn.jsp").forward(request, response);}
		
		
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
