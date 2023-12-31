package com.solvd.service;


import com.solvd.constant.TableType;
import com.solvd.entity.SolvdEntity;
import com.solvd.mapper.BaseMapper;
import com.solvd.mapper.CityMapper;
import com.solvd.mapper.FlightMapper;
import com.solvd.mapper.TicketMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.solvd.input.InputScanner.scanUserInput;
import static com.solvd.menu.Menu.printIdRequest;
import static com.solvd.menu.Menu.printInitialMenuMessage;
import static com.solvd.menu.Menu.printMainMenu;
import static com.solvd.service.CustomLogger.logInfo;
import static com.solvd.service.mapper_service.MapperServiceManager.getMapperSession;


public class Runner {
    public static void main(String[] args) {
        printInitialMenuMessage();
        String tableName = scanUserInput("[a-z]+");
        TableType tableType = TableType.valueOf(tableName.toUpperCase());

        printMainMenu(tableType);
        String userOption = scanUserInput("[1-2]");

        SqlSession session = getMapperSession();

        BaseMapper service;
        switch (tableType) {
            case CITY: service = session.getMapper(CityMapper.class);
            break;
            case FLIGHT: service = session.getMapper(FlightMapper.class);
            break;
            case TICKET: service = session.getMapper(TicketMapper.class);
            break;
            default: throw new IllegalArgumentException("There is no such mapper type");
        }

        if (userOption.equals("1")) {
            List<SolvdEntity> list =  service.getAll();
            session.commit();
            logInfo(list.toString());
        } else {
            printIdRequest();
            String idToDeleteRecord = scanUserInput("\\d+");
            service.deleteById(Integer.parseInt(idToDeleteRecord));
            session.commit();
        }
    }
}