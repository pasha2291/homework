package com.solvd.multithreading.custom_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static ExecutorService getThreadPool(int size) {
        return Executors.newFixedThreadPool(size);
    }
}
