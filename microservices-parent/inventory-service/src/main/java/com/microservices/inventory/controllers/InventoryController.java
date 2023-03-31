package com.microservices.inventory.controllers;

import com.microservices.inventory.models.dtos.AvailableProductDto;
import com.microservices.inventory.services.InventoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping("/inventoryApi")
public class InventoryController {
    private final InventoryServiceImpl inventoryService;
    @GetMapping("/getAvailableProducts/{id}")
    AvailableProductDto getAvailables(@PathVariable(value = "id") String id){
        return  inventoryService.getInventoryById(id);
    }
}
