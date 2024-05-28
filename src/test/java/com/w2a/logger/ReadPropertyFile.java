package com.w2a.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {

    public static ReadPropertyFile getInstance() {
        return new ReadPropertyFile();
    }

    public Properties getPropConst() {
        Properties properties = new Properties();
        String separator = File.separator;
        String path = System.getProperty("user.dir") + separator + "src" + separator + "test" + separator + "resources" + separator + "properties" + separator + "LogProperties.properties";
        try (InputStream inputStream = new FileInputStream(path)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Exception while reading the Log Properties File " + e);
            e.fillInStackTrace();
        }

        return properties;
    }

}
