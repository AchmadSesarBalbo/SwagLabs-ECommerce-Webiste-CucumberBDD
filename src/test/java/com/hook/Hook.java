package com.hook;

import com.DriverSingleton;
import com.utils.Browser;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hook {
    @BeforeAll
    public static void setUp() {
        String browser = System.getProperty("browser", Browser.EDGE);
        System.out.println("Browser yang dipilih: " + browser);
        DriverSingleton.setDriver(browser);
    }

    @AfterAll
    public static void tearDown() {
        DriverSingleton.exit();
    }
}
