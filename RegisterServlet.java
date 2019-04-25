package org.gareth.webapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gareth.webapp.beans.UserAccount;
import org.gareth.webapp.utils.DBUtils;
import org.gareth.webapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/WEB-INF/views/Register.jsp");

		dispatcher.forward(request, response);
		String code = (String) request.getParameter("firstname");
		System.out.println("/WEB-INF/views/Register.jsp DOGET" + code);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
	 	/*UserAccount loginedUser = MyUtils.getLoginedUser(session);*/
	 	Connection conn = MyUtils.getStoredConnection(request);
		
		String firstname = (String)request.getParameter("firstname");
		System.out.println("String firstname = (String)request.getParameter(firstname);)" + firstname);
		String lastname = (String)request.getParameter("lastname");
		String userName = (String)request.getParameter("userName");
		String password = (String)request.getParameter("password");
		String gender = (String) request.getParameter("item");
		String street1 = (String) request.getParameter("street1");
		String street2 = (String) request.getParameter("street2");
		String town = (String) request.getParameter("town");
		String city = (String) request.getParameter("city");
		String country = (String) request.getParameter("country");
		String postcode = (String) request.getParameter("postcode");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);

		UserAccount user =  new UserAccount(firstname,lastname,userName,gender,password,street1,
				street2,town,city,country,postcode);;
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUserName(userName);
		user.setPassword(password);
		user.setGender(gender);
		boolean hasError = false;
		String errorString = null;

		if (firstname == null || lastname == null || userName == null || password == null || lastname.length() == 0
				|| firstname.length() == 0 || userName.length() == 0 || password.length() == 0) {
			 hasError = true;
	            errorString = "Required Firstname/ Lastname / Username and Password!";
		}else {		
			
			try {
				 user = DBUtils.findUser(conn, userName);
				 
				 if (user != null) {
					 hasError = true;
					errorString = "User Name already exists \nChoose a different Username";
				 }
				 
			}catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
		}
		
			try {
				System.out.println("DBUtils.insertIntoUserAccount(conn, user);");
				DBUtils.insertIntoUserAccount(conn, firstname, lastname,userName, gender,password,
						street1,street2,town,city,country,postcode);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
 
            // Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
 
            // Forward to /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
 
            dispatcher.forward(request, response);
            System.out.println("/WEB-INF/views/Register.jsp DOPOST");
            
            MyUtils.storeLoginedUser(session, user);
 
            // If user checked "Remember me".
            if (remember) {
                MyUtils.storeUserCookie(response, user);
            }
            // Else delete cookie.
            else {
                MyUtils.deleteUserCookie(response);
            }
 
            if(user.getAdmin().equalsIgnoreCase("n")){
            	/*response.sendRedirect(request.getContextPath() + "/shoppingCart");*/
            	response.sendRedirect(request.getContextPath() + "/userProductList");
            }else {
            // Redirect to userInfo page.
            response.sendRedirect(request.getContextPath() + "/home");
            }
        
			

	}

}
