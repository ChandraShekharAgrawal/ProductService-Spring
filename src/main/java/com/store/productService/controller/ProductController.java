package com.store.productService.controller;

import com.store.productService.dtos.ExceptionDto;
import com.store.productService.dtos.GenericProductDto;
import com.store.productService.exceptions.NotFoundException;
import com.store.productService.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
   private ProductService productService;
   public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
       this.productService = productService;
   }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public GenericProductDto deleteProductById(@PathVariable(name = "id") long id){
        return productService.deleteProduct(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public GenericProductDto updateProductById(@PathVariable(name = "id") Long id, @RequestBody GenericProductDto product){
       product.setId(id);
       return productService.updateProduct(id, product);
    }
}
