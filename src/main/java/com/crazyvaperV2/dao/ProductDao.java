package com.crazyvaperV2.dao;

import com.crazyvaperV2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    Product findById(long id);
}
