package com.crazyvaperV2.service.interfaces;

import java.util.List;

public interface IService<T> {

    void save(T entity);

    T getById(long id);

    List<T> getAll();

    void delete(long id);

}
