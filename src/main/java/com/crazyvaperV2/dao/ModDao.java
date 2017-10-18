package com.crazyvaperV2.dao;

import com.crazyvaperV2.entity.Mod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModDao extends JpaRepository<Mod, Long> {
    Mod findById(long id);
}
