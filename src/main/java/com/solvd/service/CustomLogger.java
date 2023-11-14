package com.solvd.service;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CustomLogger {
    private final static Logger logger = LogManager.getLogger();

    public static void logInfo(String message){
        logger.log(Level.INFO, message);
    }

    public static void logError(String message){
        logger.log(Level.ERROR, message);
    }
}