package com.solvd.mapper;

import com.solvd.entity.SolvdEntity;

import java.util.List;
import java.util.Optional;

public interface BaseMapper <T extends SolvdEntity>{
    int save(T obj);
    void deleteById(int id);
    List<T> getAll();
    Optional<T> getById(int id);
}
