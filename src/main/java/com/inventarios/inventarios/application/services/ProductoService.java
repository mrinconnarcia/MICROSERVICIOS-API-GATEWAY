package com.inventarios.inventarios.application.services;

import com.inventarios.inventarios.domain.model.Productos;
import com.inventarios.inventarios.domain.ports.in.CreateProductoUseCase;
import com.inventarios.inventarios.domain.ports.in.DeleteProductoUseCase;
import com.inventarios.inventarios.domain.ports.in.GetProductoUseCase;

import java.util.List;

public class ProductoService implements CreateProductoUseCase, DeleteProductoUseCase, GetProductoUseCase {

    private final CreateProductoUseCase createProductoUseCase;
    private final DeleteProductoUseCase deleteProductoUseCase;
    private final GetProductoUseCase getProductoUseCase;

    public ProductoService(CreateProductoUseCase createProductoUseCase, DeleteProductoUseCase deleteProductoUseCase, GetProductoUseCase getProductoUseCase) {
        this.createProductoUseCase = createProductoUseCase;
        this.deleteProductoUseCase = deleteProductoUseCase;
        this.getProductoUseCase = getProductoUseCase;
    }

    @Override
    public Productos createProducto(Productos producto){
        return createProductoUseCase.createProducto(producto);
    }

    @Override
    public boolean deleteProducto(Long id){
        return deleteProductoUseCase.deleteProducto(id);
    }

    @Override
    public List<Productos> getAllProductos(){
        return getProductoUseCase.getAllProductos();
    }

}
