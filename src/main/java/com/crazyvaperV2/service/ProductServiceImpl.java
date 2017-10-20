package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.ProductDao;
import com.crazyvaperV2.entity.Product;
import com.crazyvaperV2.service.interfaces.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = Logger.getLogger(ECigServiceImpl.class);

    @Autowired
    private ProductDao productDao;


    @Override
    public void save(Product entity) {
        try {
            productDao.save(entity);
        } catch (Exception e){
            logger.error("Something wrong with save()", e);
        }
    }

    @Override
    public Product getById(long id) {
        Product product;
        try {
            product = productDao.findById(id);
        } catch (Exception e){
            logger.error("Something wrong with getById(long id)", e);
            product = null;
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> result;
        try {
            result = productDao.findAll();
        }catch (Exception e){
            logger.error("Something wrong with findAll()", e);
            result = Collections.EMPTY_LIST;
        }
        return result;
    }

    @Override
    public void delete(long id) {
        try {
            productDao.delete(id);
        } catch (Exception e){
            logger.error("Something wrong with delete(long id)", e);
        }
    }

    @Override
    public Page<Product> getAll(Integer page, Integer size, String order, String direction) {
        Page<Product> page1;
        Pageable pageable = null;
        try {
            if (direction.equals("low")) {
                Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, order));
                pageable = new PageRequest(page, size, sort);

            } else if (direction.equals("high")) {
                Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, order));
                pageable = new PageRequest(page, size, sort);
            } else {
                pageable = new PageRequest(page, size);
            }
            page1 = productDao.findAll(pageable);
        } catch (Exception e){
            logger.error("Something wrong with getAll(Integer page, Integer size, String order, String direction)", e);
            page1 = null;
        }
        return page1;
    }
}
