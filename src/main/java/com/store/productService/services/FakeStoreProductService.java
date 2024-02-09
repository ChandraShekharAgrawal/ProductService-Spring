package com.store.productService.services;

import com.store.productService.dtos.GenericProductDto;
import com.store.productService.exceptions.NotFoundException;
import com.store.productService.thirdPartyClient.productService.fakestore.FakeStoreProductDto;
import com.store.productService.thirdPartyClient.productService.fakestore.FakestoreProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private FakestoreProductServiceClient fakestoreProductServiceClient;
    public FakeStoreProductService(FakestoreProductServiceClient fakestoreProductServiceClient){
        this.fakestoreProductServiceClient = fakestoreProductServiceClient;
    }

    private GenericProductDto convertFakeStoreProductToGenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto product){
        return convertFakeStoreProductToGenericProduct(fakestoreProductServiceClient.createProduct(product));
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return convertFakeStoreProductToGenericProduct(fakestoreProductServiceClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos = fakestoreProductServiceClient.getAllProducts();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
            genericProductDtos.add(convertFakeStoreProductToGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return convertFakeStoreProductToGenericProduct(fakestoreProductServiceClient.deleteProduct(id));
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto product) {
        return convertFakeStoreProductToGenericProduct(fakestoreProductServiceClient.updateProduct(id, product));
    }
}
