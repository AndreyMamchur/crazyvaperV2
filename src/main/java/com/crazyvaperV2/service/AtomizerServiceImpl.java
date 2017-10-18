package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.AtomizerDao;
import com.crazyvaperV2.entity.Atomizer;
import com.crazyvaperV2.service.interfaces.AtomizerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AtomizerServiceImpl implements AtomizerService {

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
}
