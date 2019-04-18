package org.gareth.webapp.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.gareth.webapp.beans.Product;
import org.gareth.webapp.beans.UserAccount;
import org.gareth.webapp.utils.DBUtils;
import org.gareth.webapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/buyProduct" })
public class BuyProductServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuyProductServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 Connection conn = MyUtils.getStoredConnection(request);
		 HttpSession session = request.getSession();
		String code = (String) request.getParameter("code");
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
        Product product = null;
 
        String errorString = null;
 
        try {
            product = DBUtils.findProduct(conn, code);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && product == null) {
            response.sendRedirect(request.getServletPath() + "/userProductList");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
        request.setAttribute("user", loginedUser);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/buyProductView.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		/*response.setContentType("text/html;charset=UTF-8");*/

		/*String savePath = "C:/Users/Glenda/Desktop/PaddyPatterns/Paddy2019CA4/WebContent/" + File.separator + SAVE_DIR;
		File fileSaveDir = new File(savePath);*/

		String productCode = (String) request.getParameter("code");
		String userName = (String) request.getParameter("userName");
		String paid = (String) request.getParameter("paid");
		
		
		org.gareth.webapp.beans.ShoppingCart cart = 
				new org.gareth.webapp.beans.ShoppingCart(userName,productCode,paid);

		String errorString = null;

		// Product ID is the string literal [a-zA-Z_0-9]
		// with at least 1 character
		String regex = "\\w+";

		if (productCode == null || !productCode.matches(regex)) {
			errorString = "Product Code invalid!";
		}

		if (errorString == null) {
			try {
				DBUtils.insertIntoShoppingCart(conn, cart);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", cart);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
			dispatcher.forward(request, response);
		}
		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath() + "/userProductList");
		}
	}


}
