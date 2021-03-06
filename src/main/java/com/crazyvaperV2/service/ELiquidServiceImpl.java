package com.crazyvaperV2.service;

import com.crazyvaperV2.dao.ELiquidDao;
import com.crazyvaperV2.entity.ELiquid;
import com.crazyvaperV2.service.interfaces.ELiquidService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ELiquidServiceImpl implements ELiquidService {

    private static final Logger logger = Logger.getLogger(ECigServiceImpl.class);

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

    @Override
    public Page<ELiquid> getAll(Integer page, Integer size, String order, String direction) {
        Page<ELiquid> page1;
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
            page1 = eLiquidDao.findAll(pageable);
        } catch (Exception e){
            logger.error("Something wrong with getAll(Integer page, Integer size, String order, String direction)", e);
            page1 = null;
        }
        return page1;
    }
}
