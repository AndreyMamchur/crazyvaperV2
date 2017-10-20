package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.UserDao;
import com.crazyvaperV2.entity.User;
import com.crazyvaperV2.service.interfaces.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

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

    @Override
    public Page<User> getAll(Integer page, Integer size, String order, String direction) {
        Page<User> page1;
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
            page1 = userDao.findAll(pageable);
        } catch (Exception e){
            logger.error("Something wrong with getAll(Integer page, Integer size, String order, String direction)", e);
            page1 = null;
        }
        return page1;
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        User user = userDao.findByEmail(login);
        if (user == null) {
            throw new UsernameNotFoundException(login);
        }
        return new MyUserPrincipal(user);
    }
}
