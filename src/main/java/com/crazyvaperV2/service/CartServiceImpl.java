package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.CartDao;
import com.crazyvaperV2.entity.Cart;
import com.crazyvaperV2.service.interfaces.CartServise;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartServise {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private CartDao cartDao;

    @Override
    public void save(Cart emtity) {
        cartDao.save(emtity);
    }

    @Override
    public Cart getById(long id) {
        return cartDao.findById(id);
    }

    @Override
    public List<Cart> getAll() {
        return cartDao.findAll();
    }

    @Override
    public void delete(long id) {
        cartDao.delete(id);
    }

    @Override
    public Page<Cart> getAll(Integer page, Integer size, String order, String direction) {
        Page<Cart> page1;
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
            page1 = cartDao.findAll(pageable);
        } catch (Exception e){
            logger.error("Something wrong with getAll(Integer page, Integer size, String order, String direction)", e);
            page1 = null;
        }
        return page1;
    }

}
