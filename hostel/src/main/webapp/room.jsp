<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.hostel.model.*" %>
<%@ page import="com.hostel.dao.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Available Rooms</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
       .as{
           border-radius:20px;
       }
       
    </style>
</head>
<body>
<header>
<%
User user = (User) session.getAttribute("user");
%>
    <h1>Available Rooms</h1>
    <nav>
        <a href="index.html">Home</a>
        <a href="logout.html">Logout</a>
        <%= user.getName() %>
    </nav>
</header>
<main>
    <h2>Select a room to book</h2>
    <table>
        <thead>
        <tr>
            <th>Room Number</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
    
        RoomDAO roomDAO = new RoomDAO();
        List<Room> rooms = roomDAO.getAvailableRooms();
        if (rooms != null && !rooms.isEmpty()) {
            for (Room room : rooms) {
        %>
        <tr>
            <td><%= room.getRoomNumber() %></td>
            <td><%= room.isAvailable() ? "Available" : "Booked" %></td>
            <td>
                <form action="BookRoomServlet" method="post">
                    <input type="hidden" name="roomNumber" value="<%= room.getRoomNumber() %>">
                    <input type="hidden" name="bookedBy" value="<%= user.getName() %>"> <!-- This should be dynamic -->
                    <button type="submit">Book Now</button>
                </form>
            </td>
        </tr>
        <%
            } // end for loop
        } else {
        %>
        <tr>
            <td colspan="3">No available rooms.</td>
        </tr>
        <%
        } // end if
        %>
        </tbody>
    </table>
</main>
<footer>
    <p></p>
</footer>
</body>
</html>
