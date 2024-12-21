package com.hostel.servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.hostel.dao.UserDAO;
import com.hostel.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserDAO userDAO=new UserDAO();
		try {
			User user=userDAO.getUserByEmailAndPassword(email, password);
			
			if(user!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				if ("admin".equalsIgnoreCase(user.getRole())) {
					response.sendRedirect("admin_dashboard.jsp");
				}else {
				response.sendRedirect("room.jsp");
				}}else {
				response.sendRedirect("login.html?error=Invalid%20credentials");
			}
		}catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
