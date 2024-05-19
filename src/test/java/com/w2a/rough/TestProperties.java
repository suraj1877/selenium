package com.w2a.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) {

        Properties config = new Properties();
        final var separator = File.separator;
        final var basePath = System.getProperty("user.dir");
        final var fileLocation = basePath + separator + "src" + separator + "test" + separator + "resources" + separator + "properties" + separator + "config.properties";

        try (var fis = new FileInputStream(fileLocation)) {
            config.load(fis);
            System.out.println(config.getProperty("browser"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
