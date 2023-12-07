package com.solvd.multithreading.custom_thread;

import com.solvd.multithreading.connection_pool.BaseConnectionPool;
import lombok.SneakyThrows;

import java.sql.Connection;

public class SecondConnectionPoolThread implements Runnable {
    private BaseConnectionPool baseConnectionPool;

    public SecondConnectionPoolThread(BaseConnectionPool baseConnectionPool) {
        this.baseConnectionPool = baseConnectionPool;
    }

    @Override
    @SneakyThrows
    public void run() {
        Connection connection = baseConnectionPool.getConnection();
        Thread.sleep(15000);
        baseConnectionPool.releaseConnection(connection);
    }
}
