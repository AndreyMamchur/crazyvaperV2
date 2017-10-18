package com.crazyvaperV2.service;


import com.crazyvaperV2.dao.PaymentDao;
import com.crazyvaperV2.entity.Payment;
import com.crazyvaperV2.service.interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

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
}
