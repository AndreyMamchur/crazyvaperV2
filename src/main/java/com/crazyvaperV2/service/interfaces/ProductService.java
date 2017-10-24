package com.crazyvaperV2.service.interfaces;

import com.crazyvaperV2.entity.Product;
import org.springframework.data.domain.Page;

public interface ProductService extends IService<Product> {
    Page<Product> getAll(Integer page, Integer size);
}
