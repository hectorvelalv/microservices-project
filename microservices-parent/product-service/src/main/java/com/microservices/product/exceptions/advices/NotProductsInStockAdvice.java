package com.microservices.product.exceptions.advices;

import com.microservices.product.exceptions.NotProductsInStockException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotProductsInStockAdvice {
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(NotProductsInStockException.class)
    String notProductsInStockHandler(NotProductsInStockException notProductsInStockException){
        return notProductsInStockException.getMessage();
    }

}
