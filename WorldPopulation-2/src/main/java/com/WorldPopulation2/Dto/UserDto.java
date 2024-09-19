package com.WorldPopulation2.Dto;

import lombok.Data;

@Data
public class UserDto {

    private String username;
   private String password;
   private String role; //Eg: ADMIN,USER
   private String fullname;

}
