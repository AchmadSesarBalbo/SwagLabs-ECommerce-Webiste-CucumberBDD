package com.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeManager {
    public static WebDriver buildDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        return new ChromeDriver(options);
    }
}
