package com.inventarios.inventarios.application.usecases;

import com.inventarios.inventarios.domain.model.Productos;
import com.inventarios.inventarios.domain.ports.in.GetProductoUseCase;
import com.inventarios.inventarios.domain.ports.out.ProductosRepositoryPort;

import java.util.List;

public class GetProductoUseCaseImpl implements GetProductoUseCase {

    private final ProductosRepositoryPort productosRepositoryPort;

    public GetProductoUseCaseImpl(ProductosRepositoryPort productosRepositoryPort) {
        this.productosRepositoryPort = productosRepositoryPort;
    }

    @Override
    public List<Productos> getAllProductos() {
        return productosRepositoryPort.findAll();
    }

}
