package com.hostel.dao;

import java.sql.*;


import java.util.*;

import com.hostel.connection.DBConnection;
import com.hostel.model.*;

public class RoomDAO {
    public List<Room> getAvailableRooms() throws SQLException, ClassNotFoundException {
        List<Room> availableRooms = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM rooms WHERE is_available = 1";
        PreparedStatement statement = con.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Room room = new Room();
            room.setRoomNumber(rs.getInt("room_number"));
            room.isAvailable(rs.getBoolean("is_available"));
            room.setBookedBy(rs.getString("booked_by"));
            availableRooms.add(room);
        }

        rs.close();
        statement.close();
        con.close(); // Ensure connection is closed
        return availableRooms;
    }
       public List<Room> getAllRooms() throws SQLException , ClassNotFoundException{
    	   Connection con=DBConnection.getConnection();
    	   String s="Select * from rooms";
    	   PreparedStatement stat=con.prepareStatement(s);
    	   ResultSet r=stat.executeQuery();
    	   List<Room>rooms=new ArrayList<>();
    	   while(r.next()) {
    		   Room ro=new Room();
    		   ro.isAvailable(r.getBoolean("is_available"));
    		   ro.setBookedBy(r.getString("booked_by"));
    		   ro.setRoomNumber(r.getInt("room_number"));
    		   rooms.add(ro);
    	   }
    	   return rooms;
       }
       public boolean bookRoom(int room ,String userEmail) throws SQLException , ClassNotFoundException{
    	   Connection con=DBConnection.getConnection();
    	   String q="UPDATE rooms SET is_available = false,booked_by= ? where room_number= ?";
    	   PreparedStatement stat=con.prepareStatement(q);
    	   stat.setString(1, userEmail);
    	   stat.setInt(2, room);
    	   int rows=stat.executeUpdate();
    	   return rows > 0;
       }
}
