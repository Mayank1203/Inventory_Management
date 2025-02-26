package com.InventoryManagement.service.impl;

import com.InventoryManagement.exception.ProductCustomException;
import com.InventoryManagement.model.entity.ProductBE;
import com.InventoryManagement.model.request.ProductRequest;
import com.InventoryManagement.repository.IProductRepository;
import com.InventoryManagement.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.InventoryManagement.constants.InventoryConstants.PRODUCT_NOT_FOUND;
import static com.InventoryManagement.constants.InventoryConstants.USER_NOT_FOUND;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository IProductRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProductBE addProduct(ProductRequest productRequest) {
        ProductBE productBE = modelMapper.map(productRequest, ProductBE.class);
        return IProductRepository.save(productBE);
    }

    @Override
    public List<ProductBE> getAllProduct() {
        return IProductRepository.findAll();
    }

    @Override
    public ProductBE getProductById(String id) {
        Optional<ProductBE> productBE = IProductRepository.findById(id);
        if(productBE.isEmpty()){
            throw new ProductCustomException(PRODUCT_NOT_FOUND  , HttpStatus.NOT_FOUND);
        }
        return productBE.get();
    }

    @Override
    public ProductBE updateProduct(String id, ProductRequest productRequest) {
        // handling error
        ProductBE productBE = modelMapper.map(productRequest, ProductBE.class);
        productBE.setId(id);
        return IProductRepository.save(productBE);
    }

    @Override
    public void deleteProduct(String id) {

        Optional<ProductBE> productBE = IProductRepository.findById(id);
        if(productBE.isPresent()){
            IProductRepository.deleteById(id);
        }
    }
}
