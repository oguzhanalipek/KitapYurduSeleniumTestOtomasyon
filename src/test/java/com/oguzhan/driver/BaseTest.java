package com.oguzhan.driver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected static WebDriver driver;
    private final String driverName = "webdriver.chrome.driver";
    private final String drivePath = "src/test/resources/chromedriver.exe";

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp() {
        System.setProperty(driverName, drivePath);
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-plugins");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-extensions");
        chromeOptions.setExperimentalOption("w3c", false);
        //////////////
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        //driver.get(url);
        driver.get("chrome://newtab");

    }

    @After
    public void shutDown() {
        if (driver != null) {
            driver.close();
            driver.close();
        }
    }


}
