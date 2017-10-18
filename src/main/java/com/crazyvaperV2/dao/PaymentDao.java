package com.crazyvaperV2.dao;


import com.crazyvaperV2.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {
    Payment findById(long id);
}
