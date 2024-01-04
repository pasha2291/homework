package com.solvd.mapper;

import com.solvd.entity.database.Airport;
import com.solvd.entity.database.Arrival;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

public interface AirportMapper extends BaseMapper<Airport> {
    @Insert("INSERT INTO airport(airportCode) VALUE (#{airportCode}")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @Override
    int save(Airport airport);

    @Delete("DELETE FROM airport WHERE id = #{airportId}")
    @Override
    void deleteById(int airportId);

    @Select("SELECT id, airportCode FROM airport")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "airportCode", column = "airportCode")
    })
    @Override
    List<Airport> getAll();

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "airportCode", column = "airportCode"),
    })
    @Select("SELECT id, airportCode FROM airport WHERE id = #{airportId}")
    @Override
    Optional<Airport> getById(int airportId);
}
