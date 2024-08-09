package com.courses.jwt.jwtcourse.services;

import com.courses.jwt.jwtcourse.models.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Productservice {

   public List<Product> getAllProducts() {
      Product product = new Product();
      product.setId(1L);
      product.setName("Product 1");
      product.setDescription("Description of product 1");
      return List.of(product);
   }

}
