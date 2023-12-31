package com.solvd.mapper;

import com.solvd.entity.database.Departure;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

public interface DepartureMapper extends BaseMapper<Departure> {
    @Insert("INSERT INTO departure(airport, city, date_time) VALUES (#{name}, #{city}, #{dateTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @Override
    int save(Departure departure);

    @Delete("DELETE FROM departure WHERE id = #{departureId}")
    @Override
    void deleteById(int departureId);

    @Select("SELECT id, airport, city, date_time FROM departure")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "airport", column = "airport"),
            @Result(property = "city", column = "city"),
            @Result(property = "dateTime", column = "date_time")
    })
    @Override
    List<Departure> getAll();

    @Select("SELECT id, airport, city, date_time FROM departure WHERE id = #{departureId}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "airport", column = "airport"),
            @Result(property = "city", column = "city"),
            @Result(property = "dateTime", column = "date_time")
    })
    @Override
    Optional<Departure> getById(int departureId);
}
