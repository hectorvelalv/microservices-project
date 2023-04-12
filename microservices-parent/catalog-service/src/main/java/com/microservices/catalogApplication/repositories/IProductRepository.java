package com.microservices.catalogApplication.repositories;

import com.microservices.catalogApplication.models.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface IProductRepository extends CrudRepository<Product,String> {
    List<Product> getProductsBySku(String sku);

}
