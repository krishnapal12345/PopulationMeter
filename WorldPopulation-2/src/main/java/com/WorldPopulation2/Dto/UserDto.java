package com.WorldPopulation2.Dto;

public class UserDto {

    private String username;
   private String password;
   private String role; //Eg: ADMIN,USER
   private String fullname;
 
   public UserDto(String username, String password, String role, String fullname) {
       super();
       this.username = username;
       this.password = password;
       this.role = role;
       this.fullname = fullname;
   }

   public String getUsername() {
       return username;
   }

   public void setUsername(String username) {
       this.username = username;
   }

   public String getPassword() {
       return password;
   }

   public void setPassword(String password) {
       this.password = password;
   }

   public String getRole() {
       return role;
   }

   public void setRole(String role) {
       this.role = role;
   }

   public String getFullname() {
       return fullname;
   }

   public void setFullname(String fullname) {
       this.fullname = fullname;
   }
   

}
