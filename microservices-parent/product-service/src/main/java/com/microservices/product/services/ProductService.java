package com.microservices.product.services;

import com.microservices.product.models.dtos.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto getProductByUid(String uid);
    List<ProductResponseDto> getProductsBySku(String sku);
}
