package com.solvd.service.mapper_service;

import lombok.experimental.UtilityClass;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.sql.DataSource;

@UtilityClass
public class CredentialService {
   private static String USER = "admin";
   private static String PASSWORD = "root";
   private static String URL = "jdbc:hsqldb:mem:myDb";
   private static String DRIVER = "org.hsqldb.jdbc.JDBCDriver";

   public static DataSource getDataSource() {
      return new PooledDataSource(DRIVER, URL, USER, PASSWORD);
   }
}
