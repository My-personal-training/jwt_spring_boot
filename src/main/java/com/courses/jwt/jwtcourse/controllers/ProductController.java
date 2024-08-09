package com.courses.jwt.jwtcourse.controllers;

import com.courses.jwt.jwtcourse.models.entities.Product;
import com.courses.jwt.jwtcourse.services.AuthenticationService;
import com.courses.jwt.jwtcourse.services.JwtService;
import com.courses.jwt.jwtcourse.services.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

   private final JwtService jwtService;
   @Autowired
   private final AuthenticationService authenticationService;
   @Autowired
   private final Productservice productservice;

   public ProductController(JwtService jwtService, AuthenticationService authenticationService, Productservice productservice) {
      this.jwtService = jwtService;
      this.authenticationService = authenticationService;
      this.productservice = productservice;
   }

   @GetMapping
   public List<Product> getProducts() {
      return productservice.getAllProducts();
   }

}
