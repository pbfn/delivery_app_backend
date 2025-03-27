package com.delivery.repository;

import com.delivery.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products, Long> {

    List<Products> findByStore_id(Long storeID);

}
