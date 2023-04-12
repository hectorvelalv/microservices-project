package com.microservices.catalogApplication.models.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
@Data
@Builder
public class ProductDto {
    @NonNull
    private String uniq_id;
    private String sku;
    private String name_title;
    private String description;
    private String list_price;
    private String sale_price;
}
