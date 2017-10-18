package com.crazyvaperV2.dao;

import com.crazyvaperV2.entity.Atomizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtomizerDao extends JpaRepository<Atomizer, Long> {
    Atomizer findById(long id);
}
