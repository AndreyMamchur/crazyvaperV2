package com.crazyvaperV2.dao;

import com.crazyvaperV2.entity.ECig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ECigDao extends JpaRepository<ECig, Long> {
    ECig findById(long id);
}
