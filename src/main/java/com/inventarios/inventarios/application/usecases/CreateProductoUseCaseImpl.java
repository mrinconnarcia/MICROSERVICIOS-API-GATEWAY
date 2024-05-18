package com.inventarios.inventarios.application.usecases;

import com.inventarios.inventarios.domain.model.Productos;
import com.inventarios.inventarios.domain.ports.in.CreateProductoUseCase;
import com.inventarios.inventarios.domain.ports.out.ProductosRepositoryPort;

public class CreateProductoUseCaseImpl implements CreateProductoUseCase {

    private final ProductosRepositoryPort productosRepositoryPort;

    public CreateProductoUseCaseImpl(ProductosRepositoryPort productosRepositoryPort) {
        this.productosRepositoryPort = productosRepositoryPort;
    }

    @Override
    public Productos createProducto(Productos producto) {
        return productosRepositoryPort.save(producto);
    }

}
