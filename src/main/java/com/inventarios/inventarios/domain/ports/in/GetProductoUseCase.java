package com.inventarios.inventarios.domain.ports.in;

import com.inventarios.inventarios.domain.model.Productos;

import java.util.List;

public interface GetProductoUseCase {
    List<Productos> getAllProductos();
}
