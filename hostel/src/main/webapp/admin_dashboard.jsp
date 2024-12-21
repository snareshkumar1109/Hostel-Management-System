<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.hostel.model.*" %>
<%@ page import="com.hostel.dao.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard | Online Hotel Booking System</title>
    <link rel="stylesheet" href="dashboard.css"> 
    <style>
        table {
            width: 100%;
            border-collapse: collapse; /* Ensures borders collapse */
            margin-top: 20px;
            border-spacing: 0;
        }

        table, th, td {
            border: 1px solid black; /* Adds a solid border */
            padding: 8px;
        }

        th {
            background-color: #35424a;
            color: white; /* Ensures the header text is white */
        }

        td {
            background-color: #f9f9f9; /* Optional: Adds a light background to table cells */
        }
    </style><!-- Link to CSS file -->
</head>
<body>
    <header class="dashboard-header">
       <nav class="navbar">
    <div class="logo">
        <img src="logo-final.png" alt="HotelBooking Logo">
    </div>
    <div class="menu-icon" onclick="toggleMenu()">&#9776;</div>
    <ul class="navbar-links">
        <li><a href="#">Dashboard</a></li>
        <li><a href="index.html">Manage Hotels</a></li>
        <li><a href="manage_users.html">Manage Bookings</a></li>
        <li><a href="#">Reports</a></li>
        <li><a href="#">Profile</a></li>
        <li><a href="Home.html" class="logout">Logout</a></li>
    </ul>
</nav>
    </header>

        <main>
    <h2>Manage Rooms</h2>
    <table>
        <thead>
            <tr>
                <th>Room Number</th>
                <th>Status</th>
                <th>Booked By</th>
            </tr>
        </thead>
        <tbody>
            <% 
            RoomDAO roomDAO = new RoomDAO();
            List<Room> rooms = roomDAO.getAllRooms();
            if (rooms != null && !rooms.isEmpty()) {
                for (Room room : rooms) { 
            %>
                <tr>
                    <td><%= room.getRoomNumber() %></td>
                    <td><%= room.isAvailable() ? "Available" : "Booked" %></td>
                    <td><%= room.isAvailable() ? "N/A" : room.getBookedBy() %></td>
                </tr>
            <% 
                } // end for loop
            } else { 
            %>
                <tr>
                    <td colspan="3">No rooms available.</td>
                </tr>
            <% 
            } // end if
            %>
        </tbody>
    </table>
</main>

   
    <footer>
        <p>&copy; 2024. All rights reserved.</p>
    </footer>
    
<script>
    function toggleMenu() {
        const navbarLinks = document.querySelector('.navbar-links');
        navbarLinks.classList.toggle('active');
    }
</script>
</body>
</html>