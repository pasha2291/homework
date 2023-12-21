package com.solvd.service.dao_service;

import com.solvd.dao.CityDao;
import com.solvd.entity.database.City;
import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CityDaoService {
    private static final CityDao CITY_DAO = new CityDao();

    public static List<City> getAllDistinctCitiesSortedByName() {
        return CITY_DAO.getAll().stream().distinct().sorted(Comparator.comparing(City::getName)).collect(Collectors.toList());
    }
}