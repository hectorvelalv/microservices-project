package com.microservices.catalogApplication.exceptions;

public class ProductSkuNotFoundException extends RuntimeException{
    public ProductSkuNotFoundException() {
        super("Product sku not found :(");
    }
}
