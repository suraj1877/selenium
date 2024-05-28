package com.w2a.logger;

public class Constants {

    private final static ReadPropertyFile LOG_PROPERTIES = ReadPropertyFile.getInstance();

    public static String LOG_FILE_LOCATION = LOG_PROPERTIES.getPropConst().getProperty("LOG_FILE_LOCATION");

    public static String LOG_FILE_SIZE_LIMIT = LOG_PROPERTIES.getPropConst().getProperty("LOG_FILE_SIZE_LIMIT");

    public static String LOG_FILE_MAX_COUNT = LOG_PROPERTIES.getPropConst().getProperty("LOG_FILE_MAX_COUNT");

}
