package com.crazyvaperV2.service.interfaces;

import java.util.List;
import org.springframework.data.domain.Page;

public interface IService<T> {

    void save(T entity);

    T getById(long id);

    List<T> getAll();

    void delete(long id);

    Page<T> getAll(Integer page, Integer size, String order, String direction);
}
