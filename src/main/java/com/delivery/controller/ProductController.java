package com.delivery.controller;

import com.delivery.dto.CreateProductDTO;
import com.delivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody CreateProductDTO data) throws Exception {
        var product = productService.createProduct(data);

        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/{store_id}")
    public ResponseEntity<?> getProductsByStoreId(@PathVariable Long store_id) throws Exception {
        var products = productService.getProductByStoreId(store_id);
        System.out.println("Produtos retornados: " + products.size());
        return ResponseEntity.ok(products);
    }
}
