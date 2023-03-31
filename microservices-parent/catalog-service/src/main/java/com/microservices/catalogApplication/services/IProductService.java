package com.microservices.catalogApplication.services;

import com.microservices.catalogApplication.models.dtos.ProductDto;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface IProductService {
    ProductDto findProductByUniqId(String uniq_id);
    List<ProductDto> getProductsBySku(String sku);
}
