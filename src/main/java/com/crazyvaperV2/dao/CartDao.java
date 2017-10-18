package com.crazyvaperV2.dao;

import com.crazyvaperV2.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart, Long> {
    Cart findById(long id);
}
