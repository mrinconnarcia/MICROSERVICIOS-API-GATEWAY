package com.inventarios.inventarios.domain.ports.out;

import com.inventarios.inventarios.domain.model.Productos;

import java.util.List;

public interface ProductosRepositoryPort {
    Productos save(Productos producto);
    boolean deleteById(Long id);
    List<Productos> findAll();
}
