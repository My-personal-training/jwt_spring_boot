package com.courses.jwt.jwtcourse.controllers;

import com.courses.jwt.jwtcourse.models.dtos.LoginResponse;
import com.courses.jwt.jwtcourse.models.dtos.LoginUserDto;
import com.courses.jwt.jwtcourse.models.dtos.RegisterUserDto;
import com.courses.jwt.jwtcourse.models.entities.User;
import com.courses.jwt.jwtcourse.services.AuthenticationService;
import com.courses.jwt.jwtcourse.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class AuthenticationController {

   private final JwtService jwtService;
   @Autowired
   private final AuthenticationService authenticationService;

   public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
      this.jwtService = jwtService;
      this.authenticationService = authenticationService;
   }

   @PostMapping("/signup")
   public ResponseEntity<User> register(@RequestBody RegisterUserDto input) {
      User registeredUser = authenticationService.signup(input);

      return ResponseEntity.ok(registeredUser);
   }

   @PostMapping("/login")
   public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto input) {
      User authenticatedUser = authenticationService.authenticate(input);

      String jwtToken = jwtService.generateToken(authenticatedUser);

      LoginResponse loginResponse = new LoginResponse(jwtToken);
      loginResponse.setToken(jwtToken);
      loginResponse.setExpiresIn(jwtService.getExpirationTime());

      return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
   }
}

