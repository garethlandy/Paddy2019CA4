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
 
import org.gareth.webapp.beans.Product;
import org.gareth.webapp.beans.ShoppingCart;
import org.gareth.webapp.utils.DBUtils;
import org.gareth.webapp.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/userProductList" })
public class UserProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UserProductListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Connection conn = MyUtils.getStoredConnection(request);
    	String errorString = null;
        List<Product> list = null;
        try {
            list = DBUtils.queryProduct(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("productList", list);
    	RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/userProductListView.jsp");
        dispatcher.forward(request, response);
        
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Connection conn = MyUtils.getStoredConnection(request);
		response.setContentType("text/html;charset=UTF-8");
		
		String userName = (String) request.getParameter("user");
		String productCode = (String) request.getParameter("code");
		String paid = (String) request.getParameter("paid");
		
		ShoppingCart cart = new ShoppingCart(userName,productCode,paid);
		
		try {
			DBUtils.insertIntoShoppingCart(conn, cart);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
    }
 
}

