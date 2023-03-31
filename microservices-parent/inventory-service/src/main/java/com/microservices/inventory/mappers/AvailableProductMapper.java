package com.microservices.inventory.mappers;

import com.microservices.inventory.models.dtos.AvailableProductDto;
import com.microservices.inventory.models.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AvailableProductMapper {
    AvailableProductMapper INSTANCE = Mappers.getMapper(AvailableProductMapper.class);
    @Mapping(source = "available", target = "available")
    AvailableProductDto productToAvailableProductDto(Product product);
}
