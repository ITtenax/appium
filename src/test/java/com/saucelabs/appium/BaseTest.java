package com.saucelabs.appium;

import com.saucelabs.appium.pages.MainActivityPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.net.URL;

import io.appium.java_client.AppiumDriver;

import static com.saucelabs.appium.core.Properties.getInstance;
import static java.lang.String.format;

/**
 * User: Valentyn_Kvasov
 * Date: 28.09.2015
 * Time: 22:25
 */
public class BaseTest {
    protected MainActivityPage mainActivityPage;
    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("deviceName", getInstance().getDeviceName());
        capabilities.setCapability("platformVersion", getInstance().getPlatformVersion());
        capabilities.setCapability("platformName", getInstance().getPlatformName());
        capabilities.setCapability("app", new File(getInstance().getAppPath()).getAbsolutePath());
        capabilities.setCapability("appPackage", getInstance().getAppPackage());
        capabilities.setCapability("appActivity", getInstance().getAppActivity());
        driver = new AppiumDriver(new URL(format("%s:%s/wd/hub", getInstance().getHubUrl(), getInstance().getHubPort())), capabilities);
    }

    @BeforeMethod(dependsOnMethods = "setUp")
    public void initComponent() {
        mainActivityPage = new MainActivityPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        if(driver != null)
            driver.quit();
    }

    @DataProvider(name = "localeProvider")
    public Object[][] getDefaultSlashTestData() {
        return new Object[][]{{"1"}, {"2"}, {"3"}};
    }

    public static final String CONSTANT_TEXT = "Appium test";
}
