package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.ModDao;
import com.crazyvaperV2.entity.Mod;
import com.crazyvaperV2.service.interfaces.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModServiceImpl implements ModService {

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
        return null;
    }
}
