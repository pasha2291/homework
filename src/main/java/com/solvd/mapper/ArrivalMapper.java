package com.solvd.mapper;

import com.solvd.entity.database.Arrival;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

public interface ArrivalMapper extends BaseMapper<Arrival> {
    @Insert("INSERT INTO arrival(airport, city, date_time) VALUES (#{name}, #{city}, #{dateTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @Override
    int save(Arrival arrival);

    @Delete("DELETE FROM arrival WHERE id = #{arrivalId}")
    @Override
    void deleteById(int arrivalId);

    @Select("SELECT id, airport, city, date_time FROM arrival")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "airport", column = "airport"),
            @Result(property = "city", column = "city"),
            @Result(property = "dateTime", column = "date_time")
    })
    @Override
    List<Arrival> getAll();

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "airport", column = "airport"),
            @Result(property = "city", column = "city"),
            @Result(property = "dateTime", column = "date_time")
    })
    @Select("SELECT id, airport, city, date_time FROM arrival WHERE id = #{arrivalId}")
    @Override
    Optional<Arrival> getById(int arrivalId);
}
