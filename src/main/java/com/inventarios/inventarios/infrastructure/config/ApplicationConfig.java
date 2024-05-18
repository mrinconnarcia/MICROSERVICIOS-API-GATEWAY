package com.inventarios.inventarios.infrastructure.config;


import com.inventarios.inventarios.application.services.ProductoService;
import com.inventarios.inventarios.application.usecases.CreateProductoUseCaseImpl;
import com.inventarios.inventarios.application.usecases.DeleteProductoUseCaseImpl;
import com.inventarios.inventarios.application.usecases.GetProductoUseCaseImpl;
import com.inventarios.inventarios.domain.ports.out.ProductosRepositoryPort;
import com.inventarios.inventarios.infrastructure.repositories.JpaProductosRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductoService productoService(ProductosRepositoryPort productosRepositoryPort){
        return new ProductoService(
                new CreateProductoUseCaseImpl(productosRepositoryPort),
                new DeleteProductoUseCaseImpl(productosRepositoryPort),
                new GetProductoUseCaseImpl(productosRepositoryPort)
        );
    }

    @Bean
    public ProductosRepositoryPort productosRepositoryPort(JpaProductosRepositoryAdapter jpaProductosRepositoryAdapter){
        return jpaProductosRepositoryAdapter;
    }
}
