package com.inventarios.inventarios.infrastructure.repositories;


import com.inventarios.inventarios.domain.model.Productos;
import com.inventarios.inventarios.infrastructure.entities.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductosRepository extends JpaRepository<ProductosEntity, Long> {
}
