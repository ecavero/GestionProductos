package com.isil.app.controller;

import com.isil.app.model.Producto;
import com.isil.app.respository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProductoController {

   @Autowired
   ProductoRepository productoRepository;

   @GetMapping("/productos")
   String listarProductos(Model model) {
     List<Producto> productos = productoRepository.findAll();
     model.addAttribute("productos", productos);
     return "index";
   }

   @GetMapping("/productos/nuevo")
   String nuevoProducto(Model model) {
      Producto producto = new Producto();
      model.addAttribute("producto", producto);
      return "nuevo";
   }
}
