package com.store.productService.services;

import com.store.productService.dtos.GenericProductDto;
import com.store.productService.exceptions.NotFoundException;
import com.store.productService.models.Product;

import java.util.List;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id) throws NotFoundException;
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProduct(Long id);
    GenericProductDto updateProduct(Long id, GenericProductDto product);
}
