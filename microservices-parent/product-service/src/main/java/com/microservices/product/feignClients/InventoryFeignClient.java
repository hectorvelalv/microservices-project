package com.microservices.product.feignClients;

import com.microservices.product.models.dtos.InventoryResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", url = "http://localhost:8082")
public interface InventoryFeignClient {
    @GetMapping("/inventoryApi/getAvailableProducts/{uid}")
    InventoryResponseDto inventoryResponseDto(@PathVariable("uid") String uid);
}
