package com.w2a.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

public class TestBase {

    /*
        Webdriver
        Properties
        Logs
        ExtentReports
        DB
        Excel
        Mail
     */
    public static WebDriver driver;
    public static WebDriverWait wait;
    final static public String separator = File.separator;
    final static public String propertiesBasePath = System.getProperty("user.dir") + separator;
    public static Logger log = Logger.getLogger("devpinoyLogger");


    private Properties getConfigProperties() {
        var fileLocation = propertiesBasePath + "src" + separator + "test" + separator + "resources" + separator + "properties" + separator + "config.properties";
        return loadProperties(fileLocation);
    }

    private Properties getORProperties() {
        var fileLocation = propertiesBasePath + "src" + separator + "test" + separator + "resources" + separator + "properties" + separator + "config.properties";
        return loadProperties(fileLocation);
    }


    private Properties loadProperties(String fileLocation) {
        Properties properties = new Properties();
        try (var fis = new FileInputStream(fileLocation)) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("File Location: " + fileLocation);
            System.out.println("Error while reading the properties");
        }

        return properties;

    }


    @BeforeSuite
    public void setUp() {

        if (driver == null) {
            Properties orProperties = getORProperties();
            Properties configProperties = getConfigProperties();
            log.info("config and or properties loaded");

            switch (configProperties.getProperty("browser")) {
                case "chrome":
                    driver = new ChromeDriver();
                    log.info("chrome launched");
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    log.info("firefox launched");
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    log.info("edge launched");
                    break;
            }

            driver.get(configProperties.getProperty("testsiteurl"));
            log.info("Navigated to :" + configProperties.get("testsiteurl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        }

    }

    @AfterSuite
    public void tearDown() {

    }
}
