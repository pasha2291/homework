package com.solvd.multithreading.connection_pool;

import java.sql.Connection;

public interface BaseConnectionPool {
    Connection getConnection();
    boolean releaseConnection(Connection connection);
    String getUrl();
    String getUser();
    String getPassword();
}