package com.microservices.inventory.models.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
@Data
@Builder
public class AvailableProductDto {
    @NonNull
    private int available;
}
