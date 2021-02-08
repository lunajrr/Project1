package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.TransferDAOIMP;
import com.revature.model.Log4J2;

/**
 * Servlet implementation class PostTransferServlet
 */
public class PostTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Log4J2.info("Tried to post a transfer");
		TransferDAOIMP tranDAO = new TransferDAOIMP();
		try {
			String sendAcc = request.getParameter("sendAccNumber");
			String recAcc = request.getParameter("recAccNumber");
			double amount = Double.parseDouble(request.getParameter("amount"));
			if(tranDAO.startTransfer(sendAcc, recAcc, amount)) {
				request.getSession().setAttribute("error", null);
				request.getRequestDispatcher("CustomerViewAccountDetails").forward(request, response);
			}
			else {
				request.getSession().setAttribute("error", "Cannot post transfer");
				request.getRequestDispatcher("CustomerViewAccountDetails").forward(request, response);
			}
				
			}catch(Exception e) {
				request.getSession().setAttribute("error", "Cannot post transfer");
					request.getRequestDispatcher("CustomerViewAccountDetails").forward(request, response);
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
