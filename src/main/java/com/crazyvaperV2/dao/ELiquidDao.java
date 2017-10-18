package com.crazyvaperV2.dao;

import com.crazyvaperV2.entity.ELiquid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ELiquidDao extends JpaRepository<ELiquid, Long> {
    ELiquid findById(long id);
}
