package com.microservices.product.exceptions;

public class ProductUniqueIdNotFoundException extends RuntimeException{
    public ProductUniqueIdNotFoundException() {
        super("Product unique Id not found");
    }
}
