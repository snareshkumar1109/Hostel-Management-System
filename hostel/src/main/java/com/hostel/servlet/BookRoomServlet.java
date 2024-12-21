package com.hostel.servlet;

import com.hostel.dao.RoomDAO;
import com.hostel.model.User;
import com.hostel.dao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/BookRoomServlet")
public class BookRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomNumberStr = request.getParameter("roomNumber");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user"); // Retrieve user from session

        if (roomNumberStr != null && user != null) {
            int roomNumber = Integer.parseInt(roomNumberStr);
            RoomDAO roomDAO = new RoomDAO();
            String bookedBy = user.getName();

            try {
                boolean success = roomDAO.bookRoom(roomNumber, bookedBy);
                if (success) {
                    // Send confirmation email
                    String toEmail = user.getEmail();
                    String subject = "Room Booking Confirmation";
                    String body = "Dear " + user.getName() + ",\n\nYour booking for room number " + roomNumber + " is successful.\n\nThank you for choosing our service!";
                    Email.sendEmail(toEmail, subject, body);

                    request.setAttribute("message", "Room booked successfully! A confirmation email has been sent.");
                } else {
                    request.setAttribute("message", "Failed to book the room.");
                }
            } catch (Exception e) {
                request.setAttribute("message", "Error: " + e.getMessage());
            }

            request.getRequestDispatcher("success.html").forward(request, response);
        }
    }
}
