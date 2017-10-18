package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.UserDao;
import com.crazyvaperV2.entity.User;
import com.crazyvaperV2.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User emtity) {
        userDao.save(emtity);
    }

    @Override
    public User getById(long id) {
        return userDao.findById(id);
    }

    @Override
    public User getByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}
