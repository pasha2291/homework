package com.solvd.mapper;

import com.solvd.entity.database.Flight;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

public interface FlightMapper extends BaseMapper<Flight> {
    @Insert("INSERT INTO flight(flight_code, departure, arrival) VALUES (#{flightCode}, #{departure}, #{arrival})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @Override
    int save(Flight flight);

    @Delete("DELETE FROM flight WHERE id = #{flightId}")
    @Override
    void deleteById(int flightId);

    @Select("SELECT id, flight_code, departure, arrival FROM flight")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "flightCode", column = "flight_code"),
            @Result(property = "departure", column = "departure"),
            @Result(property = "arrival", column = "arrival")
    })
    @Override
    List<Flight> getAll();

    @Select("SELECT id, flight_code, departure, arrival FROM flight WHERE id = #{flightId}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "flightCode", column = "flight_code"),
            @Result(property = "departure", column = "departure"),
            @Result(property = "arrival", column = "arrival")
    })
    @Override
    Optional<Flight> getById(int flightId);
}
