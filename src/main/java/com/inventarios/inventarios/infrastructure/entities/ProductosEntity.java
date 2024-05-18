package com.inventarios.inventarios.infrastructure.entities;


import com.inventarios.inventarios.domain.model.Productos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Float precio;
    private Integer stock;

    public ProductosEntity() {
    }

    public ProductosEntity(Long id, String nombre, Float precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public static ProductosEntity fromDomainModel(Productos productos) {
        return new ProductosEntity(productos.getId(), productos.getNombre(), productos.getPrecio(), productos.getStock());
    }

    public Productos toDomainModel() {
        return new Productos(id, nombre, precio, stock);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
