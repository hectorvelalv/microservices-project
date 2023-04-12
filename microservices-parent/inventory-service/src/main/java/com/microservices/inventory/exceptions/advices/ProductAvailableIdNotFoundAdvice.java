package com.microservices.inventory.exceptions.advices;

import com.microservices.inventory.exceptions.ProductAvailableIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class ProductAvailableIdNotFoundAdvice {
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(ProductAvailableIdNotFoundException.class)
    String productAvailableIdNotFoundHandler(ProductAvailableIdNotFoundException productAvailableIdNotFoundException){
        return productAvailableIdNotFoundException.getMessage();
    }
}
