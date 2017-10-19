package com.crazyvaperV2.dao;

import com.crazyvaperV2.entity.ECig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ECigDao extends JpaRepository<ECig, Long> {

    @Override
    ECig save(ECig eCig);

    ECig findById(long id);

    @Override
    public Page<ECig> findAll(Pageable pageable);
}
