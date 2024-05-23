package com.w2a.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) {

       String value = String.format("src%1$stest%1$ssresources%1$sexecutables%1$schromedriver.exe","/");
        System.out.println(value);

    }
}
