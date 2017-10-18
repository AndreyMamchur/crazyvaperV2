package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.ECigDao;
import com.crazyvaperV2.entity.ECig;
import com.crazyvaperV2.service.interfaces.ECigService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ECigServiceImpl implements ECigService {

    @Autowired
    private ECigDao eCigDao;

    @Override
    public void save(ECig entity) {
        eCigDao.save(entity);
    }

    @Override
    public ECig getById(long id) {
        return eCigDao.findById(id);
    }

    @Override
    public List<ECig> getAll() {
        return eCigDao.findAll();
    }

    @Override
    public void delete(long id) {
        eCigDao.delete(id);
    }
}
