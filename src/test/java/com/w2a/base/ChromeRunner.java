package com.w2a.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class ChromeRunner implements Driver {

    private static final Logger log = LogManager.getLogger("Driver");



    @Override
    public WebDriver getDriver() {
        String separator = File.separator;
        String propertiesBasePath = System.getProperty("user.dir") + separator;
        var chromeDriverPath = String.format("src%1$stest%1$sresources%1$sexecutables%1$schromedriver.exe", separator);
        System.setProperty("webdriver.chrome.driver", propertiesBasePath + chromeDriverPath);
        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();

        log.info("chrome launched");

        return driver;
    }
}
