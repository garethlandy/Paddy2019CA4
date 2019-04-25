package org.gareth.webapp.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gareth.webapp.beans.UserAccount;
import org.gareth.webapp.interfaces.*;
import org.gareth.webapp.utils.DBUtils;
import org.gareth.webapp.utils.MyUtils;

public class UserPaymentHistory extends HttpServlet implements PaymentHistory {

	private static final long serialVersionUID = 1L;

	@Override
	public PaymentHistory clone() {
		// TODO Auto-generated method stub
		return new UserPaymentHistory();
	}
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	Connection conn = MyUtils.getStoredConnection(request);
	    	HttpSession session = request.getSession();
	    	UserAccount loginedUser = MyUtils.getLoginedUser(session);
	    	String admin = loginedUser.getAdmin();
	    	
	    	String errorString = null;
	        List<org.gareth.webapp.beans.ShoppingCart> list = null;
	        try {
	            list = DBUtils.queryShoppingCart(conn,loginedUser);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	         
	        request.setAttribute("admin", admin);
	        request.setAttribute("user", loginedUser);
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("shoppingCart", list);
	        
	        // Forward to /WEB-INF/views/homeView.jsp
	        // (Users can not access directly into JSP pages placed in WEB-INF)
	        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/shoppingCartListView.jsp");
	         
	        dispatcher.forward(request, response);
	         
	    }
	  
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	       doGet(request, response);
	       
	      
	    }
	 

}
