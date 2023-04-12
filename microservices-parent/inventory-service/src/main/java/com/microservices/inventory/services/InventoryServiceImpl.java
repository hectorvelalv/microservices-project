package com.microservices.inventory.services;

import com.microservices.inventory.exceptions.ProductAvailableIdNotFoundException;
import com.microservices.inventory.mappers.AvailableProductMapper;
import com.microservices.inventory.models.dtos.AvailableProductDto;
import com.microservices.inventory.models.entities.Product;
import com.microservices.inventory.repositories.IInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements IInventoryService {
    private final IInventoryRepository inventoryRepository;
    @Override
    public AvailableProductDto getInventoryById(String id) {
        return inventoryRepository.findById(id).map(AvailableProductMapper.INSTANCE::productToAvailableProductDto)
                .orElseThrow(ProductAvailableIdNotFoundException::new);
    }
}
