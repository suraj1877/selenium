package com.w2a.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerConfig {

    public static String LOG_FILE_LOCATION;
    public static int LOG_FILE_SIZE_LIMIT;
    public static int LOG_FILE_MAX_COUNT;

    public static void initLogger(String className) {

        Logger logger = Logger.getLogger(className);
        logger.setLevel(Level.FINE);
        //logger.addHandler(new ConsoleHandler());
        //logger.addHandler(new LoginHandler());

        try {
            LOG_FILE_LOCATION = Constants.LOG_FILE_LOCATION;
            LOG_FILE_SIZE_LIMIT = Integer.parseInt(Constants.LOG_FILE_SIZE_LIMIT);
            LOG_FILE_MAX_COUNT = Integer.parseInt(Constants.LOG_FILE_MAX_COUNT);

            FileHandler fileHandler = new FileHandler(LOG_FILE_LOCATION, LOG_FILE_SIZE_LIMIT, LOG_FILE_MAX_COUNT, true);
            fileHandler.setFormatter(new FormatterLogging());
            fileHandler.setFilter(new FilterLogging());
            logger.addHandler(fileHandler);
            logger.info("***** New Run Logging Started *****");
        } catch (SecurityException | IOException e) {
            System.out.println("LoggerConfig File Exception " + e);
            e.fillInStackTrace();
        }
    }
}
