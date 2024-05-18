package com.inventarios.inventarios.infrastructure.controllers;


import com.inventarios.inventarios.application.services.ProductoService;
import com.inventarios.inventarios.domain.model.Productos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/create")
    public ResponseEntity<Productos> createProducto(@RequestBody Productos producto){
        Productos createdProducto = productoService.createProducto(producto);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productoid}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long productoid){
      if (productoService.deleteProducto(productoid)){
        return new ResponseEntity<>(HttpStatus.OK);
      }else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @GetMapping("/all")
    public ResponseEntity<Productos> getAllProductos(){
        List<Productos> productos = productoService.getAllProductos();
        return new ResponseEntity(productos, HttpStatus.OK);
    }

}
