package com.microservices.product.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatalogResponseDto {
    private String uniq_id;
    private String sku;
    private String name_title;
    private String description;
    private String list_price;
    private String sale_price;
}
