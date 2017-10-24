package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.AtomizerDao;
import com.crazyvaperV2.entity.Atomizer;
import com.crazyvaperV2.service.interfaces.AtomizerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtomizerServiceImpl implements AtomizerService {
    private static final Logger logger = Logger.getLogger(ECigServiceImpl.class);

    @Autowired
    private AtomizerDao atomizerDao;

    @Override
    public void save(Atomizer entity) {
        save(entity);
    }

    @Override
    public Atomizer getById(long id) {
        return atomizerDao.findById(id);
    }


    @Override
    public List<Atomizer> getAll() {
        return atomizerDao.findAll();
    }

    @Override
    public void delete(long id) {
        atomizerDao.delete(id);
    }

    @Override
    public Page<Atomizer> getAll(Integer page, Integer size, String order, String direction) {
        Page<Atomizer> page1;
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
            page1 = atomizerDao.findAll(pageable);
        } catch (Exception e){
            logger.error("Something wrong with getAll(Integer page, Integer size, String order, String direction)", e);
            page1 = null;
        }
        return page1;
    }
}
