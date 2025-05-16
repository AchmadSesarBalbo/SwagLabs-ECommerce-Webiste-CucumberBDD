package com.strategy;

import com.managers.ChromeManager;
import com.managers.EdgeManager;
import com.managers.FirefoxManager;
import com.utils.Browser;
import org.openqa.selenium.WebDriver;

public class DriverStrategy {
    public static WebDriver setStrategy(String browser) {
        if (browser.equals(Browser.CHROME)) {
            return ChromeManager.buildDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            return FirefoxManager.buildDriver();
        } else if (browser.equals(Browser.EDGE)) {
            return EdgeManager.buildDriver();
        }
        else {
            return ChromeManager.buildDriver();
        }
    }
}
