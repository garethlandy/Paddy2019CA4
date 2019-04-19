package org.gareth.webapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gareth.webapp.beans.Product;
import org.gareth.webapp.beans.UserAccount;
import org.gareth.webapp.utils.DBUtils;
import org.gareth.webapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/payment" })
public class PaymentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PaymentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 HttpSession session = request.getSession();
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		request.setAttribute("user", loginedUser);
		
		
    	RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/Payment.jsp");
        dispatcher.forward(request, response);
	        
	 
	    }

	
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       doGet(request, response);
	   }
}
