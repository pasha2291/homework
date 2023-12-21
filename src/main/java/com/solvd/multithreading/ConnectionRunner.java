package com.solvd.multithreading;

import com.solvd.multithreading.connection_pool.CustomConnectionPool;
import com.solvd.multithreading.custom_thread.FirstConnectionPoolThread;
import com.solvd.multithreading.custom_thread.SecondConnectionPoolThread;

import java.util.concurrent.ExecutorService;

import static com.solvd.multithreading.custom_thread.ThreadPool.getThreadPool;

public class ConnectionRunner {
    public static void main(String[] args) {
        CustomConnectionPool cp = new CustomConnectionPool("jdbc:localhost:8080", "root", "root",5);
        Thread firstConnectionPoolThread = new FirstConnectionPoolThread(cp);
        Thread secondConnectionPoolThread = new Thread(new SecondConnectionPoolThread(cp));
        ExecutorService executorService = getThreadPool(5);
        firstConnectionPoolThread.start();
        secondConnectionPoolThread.start();
    }
}
