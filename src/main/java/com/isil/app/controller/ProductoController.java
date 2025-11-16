package com.isil.app.controller;

import com.isil.app.model.Producto;
import com.isil.app.respository.ProductoRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {

   @Autowired
   ProductoRepository productoRepository;

   @GetMapping
   String listarProductos(Model model) {
     List<Producto> productos = productoRepository.findAll();
     model.addAttribute("productos", productos);
     return "productos/index";
   }

   @GetMapping("/nuevo")
   String nuevoProducto(Model model) {
      Producto producto = new Producto();
      model.addAttribute("producto", producto);
      return "productos/nuevo";
   }

   @PostMapping
   String nuevoProducto(Model model, @Valid Producto producto, BindingResult result) {
       if (result.hasErrors()) {
           // Si hay errores, se vuelve a mostrar el formulario
           return "productos/nuevo";
       }
       productoRepository.save(producto);
      return "redirect:/productos";
   }

   @GetMapping("/editar/{id}")
   String editarProducto(Model model, @PathVariable("id") Long id) {
      Producto producto = productoRepository.findById(id)
         .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
      model.addAttribute("producto", producto);
      return "productos/editar";
   }

   @PostMapping("/actualizar")
   String actualizarProducto(Model model, @Valid Producto producto, BindingResult result) {
       if (result.hasErrors()) {
           return "productos/editar";
       }
       productoRepository.save(producto);
      return "redirect:/productos";
   }
}
