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

import org.gareth.webapp.beans.UserAccount;
import org.gareth.webapp.interfaces.PaymentStrategy;
import org.gareth.webapp.utils.DBUtils;
import org.gareth.webapp.utils.MyUtils;
@WebServlet(urlPatterns = { "/visa" })
public class VisaServlet extends HttpServlet implements PaymentStrategy {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
    	HttpSession session = request.getSession();
    	UserAccount loginedUser = MyUtils.getLoginedUser(session);
    	String admin = loginedUser.getAdmin();
    	String errorString = null;
        List<org.gareth.webapp.beans.ShoppingCart> list = null;
        System.out.println("in here visaaaaaaaaaaaaaaaaaaaaa");
        try {
            list = DBUtils.queryShoppingCart(conn,loginedUser);
            System.out.println("in here visaaaaaaaaaaaaaaaaaaaaa");
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
         
        request.setAttribute("admin", admin);
        request.setAttribute("user", loginedUser);
        request.setAttribute("errorString", errorString);
        request.setAttribute("shoppingCart", list);
	 RequestDispatcher dispatcher //
    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Visa.jsp");
	 dispatcher.forward(request, response);
 
    }
 
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	/* RequestDispatcher dispatcher //
    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");
	 dispatcher.forward(request, response);*/
	 Connection conn = MyUtils.getStoredConnection(request);
	 HttpSession session = request.getSession();
 	UserAccount loginedUser = MyUtils.getLoginedUser(session);
	 String firstname = (String) request.getParameter("user");
	 String total = (String) request.getParameter("total");
	 String user;
	 System.out.println("Visa Servlet : " + firstname + " " + total + " " + loginedUser.getUserName());
	 pay(total);
	 try {
			DBUtils.updateShoppingCart(conn, loginedUser);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	 RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/homeView.jsp");
		dispatcher.forward(request, response);
 }
 public void pay( String amount )
 {
   System.out.println("Customer has paid €" + amount + " using a Visa Card");
 }

	

}
