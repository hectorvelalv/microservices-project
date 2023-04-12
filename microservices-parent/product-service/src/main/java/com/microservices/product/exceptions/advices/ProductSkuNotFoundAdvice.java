package com.microservices.product.exceptions.advices;

import com.microservices.product.exceptions.ProductSkuNotFoundException;
import com.microservices.product.exceptions.ProductUniqueIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductSkuNotFoundAdvice {
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(ProductSkuNotFoundException.class)
    String productSkuNotFoundHandler(ProductSkuNotFoundException productSkuNotFoundException){
        return productSkuNotFoundException.getMessage();
    }


}
