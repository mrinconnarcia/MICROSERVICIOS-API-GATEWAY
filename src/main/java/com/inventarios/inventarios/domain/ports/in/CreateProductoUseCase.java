package com.inventarios.inventarios.domain.ports.in;

import com.inventarios.inventarios.domain.model.Productos;

public interface CreateProductoUseCase {
    Productos createProducto(Productos producto);

}
