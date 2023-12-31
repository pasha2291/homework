package com.solvd.dao;

import com.solvd.entity.SolvdEntity;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends SolvdEntity> {
    Optional<T> getById(int id);
    List<T> getAll();
}
