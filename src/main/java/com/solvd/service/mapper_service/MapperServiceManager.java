package com.solvd.service.mapper_service;

import com.solvd.mapper.AirportMapper;
import com.solvd.mapper.ArrivalMapper;
import com.solvd.mapper.CityMapper;
import com.solvd.mapper.DepartureMapper;
import com.solvd.mapper.FlightMapper;
import com.solvd.mapper.TicketMapper;
import lombok.experimental.UtilityClass;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import static com.solvd.service.mapper_service.CredentialService.getDataSource;

@UtilityClass
public class MapperServiceManager {

    public static SqlSession getMapperSession() {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, getDataSource());
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(CityMapper.class);
        configuration.addMapper(ArrivalMapper.class);
        configuration.addMapper(DepartureMapper.class);
        configuration.addMapper(TicketMapper.class);
        configuration.addMapper(AirportMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory.openSession();
    }
}
