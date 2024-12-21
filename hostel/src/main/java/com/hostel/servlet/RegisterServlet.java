package com.hostel.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hostel.dao.UserDAO;
import com.hostel.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String name=request.getParameter("name");
	     String email=request.getParameter("email");
	     String password=request.getParameter("password");
	     User user=new User();
	     user.setName(name);
	     user.setEmail(email);
	     user.setPassword(password);
	     UserDAO userDao=new UserDAO();
	     try {
	    	 if(userDao.registerUser(user)) {
	    		 response.sendRedirect("login.html");
	    	 }else {
	    		 response.sendRedirect("register.html?error=Registration%20failed");
	    	 }
	     }catch(Exception e) {
	    	 e.printStackTrace();
	    	 response.sendRedirect("error.html");
	     }
	}

}
