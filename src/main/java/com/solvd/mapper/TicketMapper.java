package com.solvd.mapper;

import com.solvd.entity.database.Ticket;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

public interface TicketMapper extends BaseMapper<Ticket> {
    @Insert("INSERT INTO ticket(flight, cost) VALUES (#{flight}, #{cost})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @Override
    int save(Ticket ticket);

    @Delete("DELETE FROM ticket WHERE id = #{ticketId}")
    @Override
    void deleteById(int ticketId);

    @Select("SELECT id, flight, cost FROM ticket")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "flight", column = "flight"),
            @Result(property = "cost", column = "cost")
    })
    @Override
    List<Ticket> getAll();

    @Select("SELECT id, flight, cost FROM ticket WHERE id = #{ticketId}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "flight", column = "flight"),
            @Result(property = "cost", column = "cost")
    })
    @Override
    Optional<Ticket> getById(int ticketId);
}
