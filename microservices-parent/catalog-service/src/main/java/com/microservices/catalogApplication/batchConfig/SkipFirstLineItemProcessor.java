package com.microservices.catalogApplication.batchConfig;

import com.microservices.catalogApplication.models.entities.Product;
import org.springframework.batch.item.ItemProcessor;

public class SkipFirstLineItemProcessor implements ItemProcessor<Product, Product> {

    private boolean isFirstLine = true;

    @Override
    public Product process(Product product) throws Exception {
        if (isFirstLine) {
            isFirstLine = false;
            return null; // skip first line
        }
        return product;
    }
}