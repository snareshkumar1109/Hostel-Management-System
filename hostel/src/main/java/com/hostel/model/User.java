package com.hostel.model;

public class User {
     private int id;
     private String name;
     private String email;
     private String password;
     private String role;
     public void setName(String name) {
    	 this.name=name;
     }
     public void setId(int id) {
    	 this.id=id;
     }
     public void setEmail(String email) {
    	 this.email=email;
     }
     public void setPassword(String password) {
    	 this.password=password;
     }
     public String getName() {
    	 return this.name;
     }
     public int getID() {
    	 return this.id;
     }
     public String getPassword() {
    	 return this.password;
     }
     public String getEmail() {
    	 return this.email;
     }
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
