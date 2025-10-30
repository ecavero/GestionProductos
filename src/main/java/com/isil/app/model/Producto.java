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

   @NotBlank(message = "El código es obligatorio")
   @Column(unique = true, nullable = false)
   private String codigo;

   @Column(nullable = false)
   @NotBlank(message = "El nombre es obligatorio")
   private String nombre;

   private String descripcion;

   @Column(nullable = false)
   @NotNull(message = "El precio es obligatorio")
   @DecimalMin(value = "0.0", inclusive = true, message = "El precio debe ser mayor o igual a 0")
   private Double precio;

   @NotNull(message = "El stock es obligatorio")
   @Min(value = 0, message = "El stock no puede ser negativo")
   @Column(nullable = false)
   private Integer stock;
}
