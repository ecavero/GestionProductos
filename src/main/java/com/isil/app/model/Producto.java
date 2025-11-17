package com.isil.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank()
   @Column(unique = true, nullable = false)
   private String codigo;

   @Column(nullable = false)
   @NotBlank()
   private String nombre;

   private String descripcion;

   @Column(nullable = false)
   @NotNull()
   @Min(0)
   private Double precio;

   @NotNull()
   @Min(0)
   @Column(nullable = false)
   private Integer stock;
}
