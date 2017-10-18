package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.ELiquidDao;
import com.crazyvaperV2.entity.ELiquid;
import com.crazyvaperV2.service.interfaces.ELiquidService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ELiquidServiceImpl implements ELiquidService {

    @Autowired
    private ELiquidDao eLiquidDao;

    @Override
    public void save(ELiquid emtity) {
        eLiquidDao.save(emtity);
    }

    @Override
    public ELiquid getById(long id) {
        return eLiquidDao.findById(id);
    }

    @Override
    public List<ELiquid> getAll() {
        return eLiquidDao.findAll();
    }

    @Override
    public void delete(long id) {
        eLiquidDao.delete(id);
    }
}
