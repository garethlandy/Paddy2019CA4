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

@WebServlet(urlPatterns = { "/searchProduct" })
public class SearchProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SearchProductServlet() {
		super();
	}

	@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
    	String errorString = null;
        List<Product> list = null;
        String name = (String) request.getParameter("search");
        try {
            list = DBUtils.searchProduct(conn, name);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("productList", list);
    	RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/userProductListView.jsp");
        dispatcher.forward(request, response);
	        
	 
	    }

	 @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       doGet(request, response);
	   }

}
