package com.w2a.base;


import com.w2a.logger.LoggerConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


    public static Logger log = Logger.getLogger(TestBase.class.getName());

    static {
        LoggerConfig.initLogger(TestBase.class.getName());
    }

    public static WebDriver driver;
    public static WebDriverWait wait;
    final static public String separator = File.separator;
    final static public String propertiesBasePath = System.getProperty("user.dir") + separator;
    private Properties or;

    private Properties getConfig() {
        var fileLocation = propertiesBasePath + "src" + separator + "test" + separator + "resources" + separator + "properties" + separator + "config.properties";
        return loadProperties(fileLocation);
    }

    private Properties getORProperties() {
        var fileLocation = propertiesBasePath + "src" + separator + "test" + separator + "resources" + separator + "properties" + separator + "OR.properties";
        return loadProperties(fileLocation);
    }


    private Properties loadProperties(String fileLocation) {
        Properties properties = new Properties();
        try (var fis = new FileInputStream(fileLocation)) {
            properties.load(fis);
        } catch (IOException e) {
            log.severe("Error while reading the Properties file " + e);
            log.severe("File Location: " + fileLocation);
            e.fillInStackTrace();
        }
        return properties;
    }

    public void click(String locator) {
        driver.findElement(By.xpath(or.getProperty(locator)))
                .click();
        log.info("Element clicked " + locator);
    }


    @BeforeSuite
    public void setUp() {

        if (driver == null) {
            or = getORProperties();
            Properties config = getConfig();
            log.info("Config and OR properties loaded");

            switch (config.getProperty("browser")) {
                case "chrome":
                    driver = new ChromeRunner().getDriver();
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

            driver.get(config.getProperty("testsiteurl"));
            log.info("Navigated to : " + config.get("testsiteurl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

        log.info("test execution completed");
    }
}
