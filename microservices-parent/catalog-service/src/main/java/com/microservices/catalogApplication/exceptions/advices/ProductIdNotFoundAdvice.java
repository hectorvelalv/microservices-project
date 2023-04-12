package com.microservices.catalogApplication.exceptions.advices;

import com.microservices.catalogApplication.exceptions.ProductIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class ProductIdNotFoundAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ProductIdNotFoundException.class)
    String productIdNotFountHandler(ProductIdNotFoundException productIdNotFoundException){
        return productIdNotFoundException.getMessage();
    }
}
