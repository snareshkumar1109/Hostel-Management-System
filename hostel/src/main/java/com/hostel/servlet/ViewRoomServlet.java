package com.hostel.servlet;
import com.hostel.dao.RoomDAO;

import com.hostel.model.Room;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ViewRoomServlet
 */
@WebServlet("/ViewRoomServlet")
public class ViewRoomServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RoomDAO roomdao=new RoomDAO();
		try {
			List<Room> available=roomdao.getAvailableRooms();
			request.setAttribute("rooms", available);
			request.getRequestDispatcher("room.jsp").forward(request, response);
		}catch(Exception e) {
		  e.printStackTrace();
		  response.sendRedirect("error.html");
		}
	}

}
