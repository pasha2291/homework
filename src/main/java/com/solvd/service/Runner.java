package com.solvd.service;


import com.solvd.constant.TableType;
import com.solvd.entity.SolvdEntity;
import com.solvd.mapper.AirportMapper;
import com.solvd.mapper.ArrivalMapper;
import com.solvd.mapper.BaseMapper;
import com.solvd.mapper.CityMapper;
import com.solvd.mapper.DepartureMapper;
import com.solvd.mapper.TicketMapper;
import com.solvd.service.xml.BaseXmlService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.solvd.input.InputScanner.scanUserInput;
import static com.solvd.menu.Menu.printIdRequest;
import static com.solvd.menu.Menu.printInitialMenuMessage;
import static com.solvd.menu.Menu.printMainMenu;
import static com.solvd.service.CustomLogger.logInfo;
import static com.solvd.service.mapper_service.MapperServiceManager.getMapperSession;
import static com.solvd.service.xml.dom.service.DomServiceManager.getDomService;
import static com.solvd.service.xml.jaxb.service.JaxbServiceManager.getJaxbService;


public class Runner {
    public static void main(String[] args) {
        printInitialMenuMessage();
        String tableName = scanUserInput("[a-z]+");
        TableType tableType = TableType.valueOf(tableName.toUpperCase());

        printMainMenu(tableType);
        String userOption = scanUserInput("[1-4]");

        SqlSession session = getMapperSession();

        BaseMapper service;
        switch (tableType) {
            case AIRPORT: service = session.getMapper(AirportMapper.class);
                break;
            case ARRIVAL: service = session.getMapper(ArrivalMapper.class);
                break;
            case DEPARTURE: service = session.getMapper(DepartureMapper.class);
                break;
            case CITY: service = session.getMapper(CityMapper.class);
                break;
            case TICKET: service = session.getMapper(TicketMapper.class);
                break;
            default: throw new IllegalArgumentException("There is no such mapper type");
        }

        switch (userOption) {
            case "1": {
                List<SolvdEntity> list = service.getAll();
                session.commit();
                logInfo(list.toString());
                break;
            }
            case "2":
                printIdRequest();
                String idToDeleteRecord = scanUserInput("\\d+");
                service.deleteById(Integer.parseInt(idToDeleteRecord));
                session.commit();
                break;
            case "3": {
                BaseXmlService domService = getDomService(tableType);
                List<SolvdEntity> list = domService.getList();
                for (SolvdEntity obj : list) {
                    service.save(obj);
                }
                break;
            }
            case "4": {
                BaseXmlService jaxbService = getJaxbService(tableType);
                List<SolvdEntity> list = jaxbService.getList();
                for (SolvdEntity obj : list) {
                    service.save(obj);
                }
                break;
            }
            default:
                throw new IllegalArgumentException("There is no such option");
        }
    }
}