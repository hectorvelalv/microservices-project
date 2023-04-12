package com.microservices.inventory.exceptions;
public class ProductAvailableIdNotFoundException extends RuntimeException{
    public ProductAvailableIdNotFoundException() {
        super("unique id not found :(");
    }
}
