package com.solvd.service.xml;

import com.solvd.entity.SolvdEntity;

import java.util.List;

public interface BaseXmlService <T extends SolvdEntity> {
    List<T> getList();
}
