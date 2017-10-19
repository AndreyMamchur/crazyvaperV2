package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.ECigDao;
import com.crazyvaperV2.entity.ECig;
import com.crazyvaperV2.service.interfaces.ECigService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
public class ECigServiceImpl implements ECigService {

    private static final Logger logger = Logger.getLogger(ECigServiceImpl.class);

    @Autowired
    private ECigDao eCigDao;

    @Override
    public void save(ECig entity) {
        try {
        eCigDao.save(entity);
        } catch (Exception e){
            logger.error("Something wrong with save()", e);
        }
    }

    @Override
    public ECig getById(long id) {
        ECig eCig;
        try {
            eCig = eCigDao.findById(id);
        } catch (Exception e){
            logger.error("Something wrong with getById(long id)", e);
            eCig = null;
        }
        return eCig;
    }

    @Override
    public List<ECig> getAll() {
        List<ECig> result;
        try {
            result = eCigDao.findAll();
        }catch (Exception e){
            logger.error("Something wrong with findAll()", e);
            result = Collections.EMPTY_LIST;
        }
        return result;
    }

    @Override
    public Page<ECig> getAll(Integer page, Integer size, String order, String direction) {
        Page<ECig> page1;
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
            page1 = eCigDao.findAll(pageable);
        } catch (Exception e){
            logger.error("Something wrong with getAll(Integer page, Integer size, String order, String direction)", e);
            page1 = null;
        }
        return page1;
    }

    @Override
    public void delete(long id) {
        try {
            eCigDao.delete(id);
        } catch (Exception e){
            logger.error("Something wrong with delete(long id)", e);
        }
    }
}
