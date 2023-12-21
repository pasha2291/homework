package com.solvd.connection_pool;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class CustomConnectionPool implements BaseConnectionPool {
    private int size;
    private String url;
    private String user;
    private String password;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections;

    public CustomConnectionPool(String url, String user, String password, int size) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.size = size;
    }

    @Override
    public synchronized Connection getConnection() {
        if(connectionPool == null) {
            initConnectionPool();
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public synchronized boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @SneakyThrows
    private void initConnectionPool() {
        connectionPool = new ArrayList<>(size);
        usedConnections = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            connectionPool.add(DriverManager.getConnection(url, user, password));
        }
    }
}
