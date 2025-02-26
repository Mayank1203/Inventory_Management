package com.InventoryManagement.repository;

import com.InventoryManagement.model.entity.ProductBE;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<ProductBE , String> {
}
