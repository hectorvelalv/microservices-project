package com.microservices.catalogApplication.mappers;

import com.microservices.catalogApplication.models.dtos.ProductDto;
import com.microservices.catalogApplication.models.dtos.ProductDto.ProductDtoBuilder;
import com.microservices.catalogApplication.models.entities.Product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-29T12:48:52-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (JetBrains s.r.o.)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDtoBuilder productDto = ProductDto.builder();

        productDto.uniq_id( product.getUniq_id() );
        productDto.sku( product.getSku() );
        productDto.name_title( product.getName_title() );
        productDto.description( product.getDescription() );
        productDto.list_price( product.getList_price() );
        productDto.sale_price( product.getSale_price() );

        return productDto.build();
    }
}
