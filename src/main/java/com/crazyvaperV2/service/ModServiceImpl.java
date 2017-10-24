package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.ModDao;
import com.crazyvaperV2.entity.Mod;
import com.crazyvaperV2.service.interfaces.ModService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModServiceImpl implements ModService {
    private static final Logger logger = Logger.getLogger(ECigServiceImpl.class);

    @Autowired
    private ModDao modDao;

    @Override
    public void save(Mod emtity) {
        modDao.save(emtity);
    }

    @Override
    public Mod getById(long id) {
        return modDao.findById(id);
    }

    @Override
    public List<Mod> getAll() {
        return modDao.findAll();
    }

    @Override
    public void delete(long id) {
        modDao.delete(id);
    }

    @Override
    public Page<Mod> getAll(Integer page, Integer size, String order, String direction) {
        Page<Mod> page1;
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
            page1 = modDao.findAll(pageable);
        } catch (Exception e){
            logger.error("Something wrong with getAll(Integer page, Integer size, String order, String direction)", e);
            page1 = null;
        }
        return page1;
    }
}
