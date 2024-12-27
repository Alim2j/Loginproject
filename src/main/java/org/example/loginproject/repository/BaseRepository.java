package org.example.loginproject.repository;

import org.example.loginproject.model.BaseModel;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository <T extends BaseModel<ID>,ID extends Serializable>{
    void save(T entity);
    void update(T entity);
    T findById(ID id);
    List<T> findAll();
    void delete(T entity);
}
