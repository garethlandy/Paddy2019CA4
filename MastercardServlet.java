package org.gareth.webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gareth.webapp.interfaces.PaymentStrategy;

@WebServlet(urlPatterns = { "/mastercard" })
public class MastercardServlet extends HttpServlet implements PaymentStrategy {

	private static final long serialVersionUID = 1L;
	
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 //request.getAttribute(name)
	        // Forward to /WEB-INF/views/loginView.jsp
	        // (Users can not access directly into JSP pages placed in WEB-INF)
		 RequestDispatcher dispatcher //
         = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Mastercard.jsp");
		 dispatcher.forward(request, response);
	 
	    }
	 
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 RequestDispatcher dispatcher //
         = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");
		 dispatcher.forward(request, response);
		 
	 }

	@Override
	public void pay(String amount) {
		// TODO Auto-generated method stub
		
	}
	 }


