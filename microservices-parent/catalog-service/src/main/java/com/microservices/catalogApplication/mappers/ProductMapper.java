package com.microservices.catalogApplication.mappers;

import com.microservices.catalogApplication.models.dtos.ProductDto;
import com.microservices.catalogApplication.models.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto productToProductDto(Product product);
}
