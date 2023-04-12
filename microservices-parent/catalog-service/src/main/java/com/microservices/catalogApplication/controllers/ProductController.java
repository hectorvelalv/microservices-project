package com.microservices.catalogApplication.controllers;

import com.microservices.catalogApplication.models.dtos.ProductDto;
import com.microservices.catalogApplication.services.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/catalogApi")
public class ProductController {
    private final ProductServiceImpl productService;
    @GetMapping("/getProduct/{id}")
    ProductDto getProduct(@PathVariable(value = "id")String id){
        return  productService.findProductByUniqId(id);
    }
    @GetMapping("/getProductsBySku/{sku}")
    List<ProductDto> getProductsBySku(@PathVariable(value = "sku") String sku){
        return  productService.getProductsBySku(sku);}
}
