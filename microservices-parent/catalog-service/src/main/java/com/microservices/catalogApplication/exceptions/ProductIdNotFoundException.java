package com.microservices.catalogApplication.exceptions;

public class ProductIdNotFoundException extends RuntimeException{
    public ProductIdNotFoundException() {
        super("Product unique id not found.");
    }
}
