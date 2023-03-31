package com.microservices.product.controller;

import com.microservices.product.exceptions.NotProductsInStockException;
import com.microservices.product.exceptions.ProductSkuNotFoundException;
import com.microservices.product.exceptions.ProductUniqueIdNotFoundException;
import com.microservices.product.models.dtos.ProductResponseDto;
import com.microservices.product.services.ProductServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import java.util.List;

@RestController
@RequestMapping("/productAPI")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    @CircuitBreaker(name = "product-service", fallbackMethod = "fallback")
    @GetMapping("/getProductsByUid/{uid}")
    public ResponseEntity<ProductResponseDto> getProductByUid(@PathVariable(value = "uid") String uid){
        return ResponseEntity.status(200).body(productService.getProductByUid(uid));
    }
    @CircuitBreaker(name = "product-service", fallbackMethod = "fallback")
    @GetMapping("/getProductsBySku/{sku}")
    public ResponseEntity<List<ProductResponseDto>> getProductsBySku(@PathVariable(value = "sku") String sku){
        return ResponseEntity.status(200).body(productService.getProductsBySku(sku));
    }

    public ResponseEntity<String> fallback(  Throwable throwable ) {
        switch (throwable.getClass().getSimpleName()) {
            case "ProductUniqueIdNotFoundException" -> throw new ProductUniqueIdNotFoundException();
            case "ProductSkuNotFoundException" -> throw new ProductSkuNotFoundException();
        }
        return ResponseEntity.status(503).body("something went wrong, pls try it in 15 seconds");
    }
}
