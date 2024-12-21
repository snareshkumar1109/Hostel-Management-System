package com.hostel.model;

public class Room {
      private int roomNumber;
      private boolean isAvailable;
      private String bookedBy;
      public int getRoomNumber() {
    	  return roomNumber;
      }
      public boolean isAvailable() {
    	  return isAvailable;
      }
      public String getBookedBy() {
    	  return bookedBy;
      }
      public void setRoomNumber(int roomNumber) {
    	  this.roomNumber=roomNumber;
      }
      public void isAvailable(boolean Available) {
    	  isAvailable =Available;
      }
      public void setBookedBy(String bookedby) {
    	  this.bookedBy=bookedby;
      }
      
}
