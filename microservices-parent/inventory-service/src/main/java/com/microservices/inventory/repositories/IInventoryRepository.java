package com.microservices.inventory.repositories;

import com.microservices.inventory.models.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IInventoryRepository extends CrudRepository<Product,String> {
}
