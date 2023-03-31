package com.microservices.inventory.mappers;

import com.microservices.inventory.models.dtos.AvailableProductDto;
import com.microservices.inventory.models.dtos.AvailableProductDto.AvailableProductDtoBuilder;
import com.microservices.inventory.models.entities.Product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-29T12:53:39-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (JetBrains s.r.o.)"
)
public class AvailableProductMapperImpl implements AvailableProductMapper {

    @Override
    public AvailableProductDto productToAvailableProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        AvailableProductDtoBuilder availableProductDto = AvailableProductDto.builder();

        availableProductDto.available( product.getAvailable() );

        return availableProductDto.build();
    }
}
