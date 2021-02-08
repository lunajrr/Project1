package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.TransferDAOIMP;
import com.revature.model.Log4J2;

/**
 * Servlet implementation class DecideTransferServlet
 */
public class DecideTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecideTransferServlet() {
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
		Log4J2.info("Tried to decide a transfer");
		try {
		int tid = Integer.parseInt(request.getParameter("transferID"));
		String decision = request.getParameter("decision");
		TransferDAOIMP transferDAO = new TransferDAOIMP();
		if(transferDAO.decideTransfer(tid, decision)) {
			request.getSession().setAttribute("error", null);
			
			request.getRequestDispatcher("viewMyPendingTransfers").forward(request, response);}
			else {
				request.getSession().setAttribute("error", "Could not modify the transfer");
		
		request.getRequestDispatcher("viewMyPendingTransfers").forward(request, response);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
