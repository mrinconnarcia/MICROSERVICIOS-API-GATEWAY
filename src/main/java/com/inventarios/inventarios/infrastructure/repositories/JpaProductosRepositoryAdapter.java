package com.inventarios.inventarios.infrastructure.repositories;


import com.inventarios.inventarios.domain.model.Productos;

import com.inventarios.inventarios.infrastructure.entities.ProductosEntity;
import com.inventarios.inventarios.domain.ports.out.ProductosRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JpaProductosRepositoryAdapter implements ProductosRepositoryPort {

    private final JpaProductosRepository jpaProductosRepository;

    public JpaProductosRepositoryAdapter(JpaProductosRepository jpaProductosRepository) {
        this.jpaProductosRepository = jpaProductosRepository;
    }

    @Override
    public Productos save(Productos producto) {
        ProductosEntity productosEntity = ProductosEntity.fromDomainModel(producto);
        ProductosEntity savedProductosEntity = jpaProductosRepository.save(productosEntity);
        return savedProductosEntity.toDomainModel();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaProductosRepository.existsById(id)) {
            jpaProductosRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Productos> findAll() {
        return jpaProductosRepository.findAll().stream()
                .map(ProductosEntity::toDomainModel)
                .collect(Collectors.toList());
    }



}