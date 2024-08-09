package com.courses.jwt.jwtcourse.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
   private String token;

   private long expiresIn;

   public LoginResponse(String token) {
      this.token = token;
   }
}