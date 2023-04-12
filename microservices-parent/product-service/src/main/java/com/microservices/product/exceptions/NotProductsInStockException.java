package com.microservices.product.exceptions;

public class NotProductsInStockException extends RuntimeException{
    public NotProductsInStockException() {
        super("There is 0 products in stock :(");
    }
}
