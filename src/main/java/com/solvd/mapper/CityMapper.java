package com.solvd.mapper;

import com.solvd.entity.database.City;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

public interface CityMapper extends BaseMapper<City> {
    @Insert("INSERT into city(name, country) VALUES (#{name}, #{country})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @Override
    int save(City city);

    @Delete("DELETE FROM city WHERE id = #{cityId}")
    @Override
    void deleteById(int cityId);

    @Select("SELECT id, name, country FROM city")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "country", column = "country")
    })
    @Override
    List<City> getAll();

    @Select("SELECT id, name, country FROM city WHERE id = #{cityId}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "country", column = "country")
    })
    @Override
    Optional<City> getById(int cityId);
}
