package org.gareth.webapp.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet(urlPatterns = { "/userReview" })
public class UserReviewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserReviewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		HttpSession session = request.getSession();
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		String admin = loginedUser.getAdmin();

		String errorString = null;
		List<org.gareth.webapp.beans.ProductReview> list = null;

		try {
			list = DBUtils.reviews(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		request.setAttribute("admin", admin);
		request.setAttribute("user", loginedUser);
		request.setAttribute("errorString", errorString);
		request.setAttribute("productReview", list);

		// Forward to /WEB-INF/views/homeView.jsp
		// (Users can not access directly into JSP pages placed in WEB-INF)
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/ProductReview.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String comment = (String) request.getParameter("comment");
		String code = (String) request.getParameter("code");
		String star = (String) request.getParameter("rating");
		String name = (String) request.getParameter("name");
		String manu = (String) request.getParameter("manufacturer");

		String userName = (String) request.getParameter("userName");
		HttpSession session = request.getSession();

		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		System.out.println("String productCode = (String) request.getParameter()" + comment + " " + code + " "
				+ loginedUser.getUserName() + " " + star + " " + name + " " + manu);

		org.gareth.webapp.beans.ProductReview productReview = new org.gareth.webapp.beans.ProductReview(code,
				loginedUser.getUserName(), comment, star);
		try {
			DBUtils.insertProductReview(conn, productReview);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		response.sendRedirect(request.getContextPath() + "/home");

	}

}
