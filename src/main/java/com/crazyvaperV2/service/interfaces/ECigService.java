package com.crazyvaperV2.service.interfaces;

import com.crazyvaperV2.entity.ECig;
import org.springframework.data.domain.Page;

public interface ECigService extends IService<ECig> {
    Page<ECig> getAll(Integer page, Integer size, String order, String Direction);

}
