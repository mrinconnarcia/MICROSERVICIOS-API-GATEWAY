package com.inventarios.inventarios.application.usecases;

import com.inventarios.inventarios.domain.ports.in.DeleteProductoUseCase;
import com.inventarios.inventarios.domain.ports.out.ProductosRepositoryPort;

public class DeleteProductoUseCaseImpl implements DeleteProductoUseCase {

    private final ProductosRepositoryPort productosRepositoryPort;

    public DeleteProductoUseCaseImpl(ProductosRepositoryPort productosRepositoryPort) {
        this.productosRepositoryPort = productosRepositoryPort;
    }

    @Override
    public boolean deleteProducto(Long id) {
        return productosRepositoryPort.deleteById(id);
    }

}
