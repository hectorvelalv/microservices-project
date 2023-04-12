package com.microservices.inventory.services;

import com.microservices.inventory.models.dtos.AvailableProductDto;
import org.springframework.stereotype.Service;
@Service
public interface IInventoryService {
    AvailableProductDto getInventoryById(String id);
}
