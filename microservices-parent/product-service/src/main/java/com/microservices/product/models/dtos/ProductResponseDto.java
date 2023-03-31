package com.microservices.product.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private String uniq_id;
    private String sku;
    private String name_title;
    private String description;
    private String list_price;
    private String sale_price;
    private Integer available;
}
