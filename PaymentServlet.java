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
		
		String cardChoice="";
		   int selectedItem;
		   String item = request.getParameter("item");
		   selectedItem = Integer.parseInt(item);
		   
		   PaymentContext ctx = null;
		    ctx = new PaymentContext();
		   
		   if(selectedItem == 1) {
			   cardChoice = "/WEB-INF/views/Mastercard.jsp";
		   }else if (selectedItem == 2) {
			   //cardChoice = "/WEB-INF/views/Visa.jsp";
			   ctx.setPaymentStrategy(new VisaServlet());
			   //response.sendRedirect(request.getContextPath() + "/visa");
			   //ctx.setPaymentStrategy(new VisaServlet());
		   }else if  (selectedItem == 2) {
			   cardChoice = "/WEB-INF/views/Amex.jsp";
		   }
    	/*RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher(selectedItem);
        dispatcher.forward(request, response);*/
	        
	 
	    }

	
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		   
		   String cardChoice="";
		   int selectedItem;
		   String item = request.getParameter("item");
		   selectedItem = Integer.parseInt(item);
		   
		   PaymentContext ctx = null;
		    ctx = new PaymentContext();
		   
		   if(selectedItem == 1) {
			   cardChoice = "/WEB-INF/views/Mastercard.jsp";
		   }else if (selectedItem == 2) {
			   //cardChoice = "/WEB-INF/views/Visa.jsp";
			   ctx.setPaymentStrategy(new VisaServlet());
			   //response.sendRedirect(request.getContextPath() + "/visa");
			   //ctx.setPaymentStrategy(new VisaServlet());
		   }else if  (selectedItem == 2) {
			   cardChoice = "/WEB-INF/views/Amex.jsp";
		   }
		   
		   /*RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher(cardChoice);
	        dispatcher.forward(request, response);*/
	   }
}
