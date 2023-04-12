package com.microservices.product.exceptions;

public class ProductSkuNotFoundException extends RuntimeException{

    public ProductSkuNotFoundException() {
        super("Product sku not found");
    }
}
