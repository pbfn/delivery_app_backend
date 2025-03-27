package com.delivery.service;

import com.delivery.dto.CreateProductDTO;
import com.delivery.exceptions.ResourceNotFoundException;
import com.delivery.model.Products;
import com.delivery.repository.ProductRepository;
import com.delivery.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductRepository productRepository;

    public Products createProduct(CreateProductDTO data) {
        var store = storeRepository.findById(data.store_id())
                .orElseThrow(() -> new ResourceNotFoundException("There is no store with that ID"));

        var product = new Products(
                data.name(),
                data.description(),
                data.price(),
                data.imageUrl(),
                store
        );

        return productRepository.save(product);
    }

    public List<Products> getProductByStoreId(Long storeID) {

        storeRepository.findById(storeID)
                .orElseThrow(() -> new ResourceNotFoundException("There is no store with that ID"));

        return productRepository.findByStore_id(storeID);

    }
}
