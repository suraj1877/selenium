package com.w2a.base;


import org.openqa.selenium.WebDriver;

import java.io.File;

public class ChromeRunner implements Driver {

    @Override
    public WebDriver getDriver() {
        var separator = File.separator;
        var chromeDriverPath = System.getProperty("user.dir") + separator + "src" + separator + "test" + separator + "resources" + separator + "executables" + separator + "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        return new org.openqa.selenium.chrome.ChromeDriver();
    }
}
