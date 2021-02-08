package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.UserDAOIMP;
import com.revature.model.Log4J2;
import com.revature.model.User;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Log4J2.info("Tried to log in");
		UserDAOIMP userDAO = new UserDAOIMP();
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		if(username !=null)
			username = username.toUpperCase();
		User user = userDAO.logIn(username, password);
		
		if(user.getEmployee() == null) {
			request.getSession().setAttribute("logInn", "Couldn't find that Username/password combination");
			request.getRequestDispatcher("logIn.jsp").forward(request, response);
		}
		else {
			request.getSession().setAttribute("logInn", null);
			request.getSession().setAttribute("User", user);
		if(user.getEmployee())
			request.getRequestDispatcher("employee.jsp").forward(request, response);
		else
			request.getRequestDispatcher("customer.jsp").forward(request, response);}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
