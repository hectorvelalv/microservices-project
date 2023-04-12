package com.microservices.product.feignClients;

import com.microservices.product.models.dtos.CatalogResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "catalog-service", url = "http://localhost:8084")
public interface CatalogFeignClient {
    @GetMapping("/catalogApi/getProduct/{uid}")
    CatalogResponseDto getProduct(@PathVariable("uid") String uid);
    @GetMapping("/catalogApi/getProductsBySku/{sku}")
    List<CatalogResponseDto> getProductsBySku(@PathVariable String sku);
}