package com.courses.jwt.jwtcourse.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "products")
@Entity
@Data
public class Product {

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Long id;

      @Column(nullable = false)
      private String name;

      @Column(nullable = false)
      private String description;

}
