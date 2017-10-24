package com.crazyvaperV2.service;


import com.crazyvaperV2.dao.PaymentDao;
import com.crazyvaperV2.entity.Payment;
import com.crazyvaperV2.service.interfaces.PaymentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public void save(Payment emtity) {
        paymentDao.save(emtity);
    }

    @Override
    public Payment getById(long id) {
        return paymentDao.findById(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentDao.findAll();
    }

    @Override
    public void delete(long id) {
        paymentDao.delete(id);
    }

    @Override
    public Page<Payment> getAll(Integer page, Integer size, String order, String direction) {
        Page<Payment> page1;
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
            page1 = paymentDao.findAll(pageable);
        } catch (Exception e){
            logger.error("Something wrong with getAll(Integer page, Integer size, String order, String direction)", e);
            page1 = null;
        }
        return page1;
    }
}
