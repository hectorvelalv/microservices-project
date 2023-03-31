package com.microservices.catalogApplication.services;

import com.microservices.catalogApplication.exceptions.ProductIdNotFoundException;
import com.microservices.catalogApplication.exceptions.ProductSkuNotFoundException;
import com.microservices.catalogApplication.mappers.ProductMapper;
import com.microservices.catalogApplication.models.dtos.ProductDto;
import com.microservices.catalogApplication.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    @Override
    public ProductDto findProductByUniqId(String uniq_id) {
        return productRepository.findById(uniq_id)
                .map(ProductMapper.INSTANCE::productToProductDto)
                .orElseThrow(ProductIdNotFoundException::new);
    }
    @Override
    public List<ProductDto> getProductsBySku(String sku) {
        if(productRepository.getProductsBySku(sku).isEmpty()) throw new ProductSkuNotFoundException();
        List<ProductDto> productDtoList = new ArrayList<>();
        productRepository.getProductsBySku(sku)
                .forEach(p -> productDtoList.add(
                        ProductMapper.INSTANCE.productToProductDto(p)
                ));
        return productDtoList;
    }
}
