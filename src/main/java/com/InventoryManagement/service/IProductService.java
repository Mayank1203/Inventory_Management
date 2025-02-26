package com.InventoryManagement.service;

import com.InventoryManagement.model.entity.ProductBE;
import com.InventoryManagement.model.request.ProductRequest;

import java.util.List;

public interface IProductService {

    ProductBE addProduct(ProductRequest productRequest);

    List<ProductBE> getAllProduct() ;

    ProductBE getProductById(String id);

    ProductBE updateProduct(String id , ProductRequest productRequest);

    void deleteProduct(String id) ;


}
