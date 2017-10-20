package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.CartDao;
import com.crazyvaperV2.entity.Cart;
import com.crazyvaperV2.service.interfaces.CartServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartServise {

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
        return null;
    }
}
