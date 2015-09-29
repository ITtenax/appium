package com.saucelabs.appium.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;

import static com.saucelabs.appium.core.TestReporter.logPositive;
import static com.saucelabs.appium.core.TestReporter.logStep;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * User: Valentyn_Kvasov
 * Date: 28.09.2015
 * Time: 22:56
 */

public class MainActivityPage {
    private RemoteWebDriver driver;

    public static By MAIN_MENU = By.className("android.widget.Spinner");
    public static By MAIN_ITEMS = By.className("android.widget.TextView");
    public static By TEXT_INPUT = By.id("textView1");
    public static By EDIT_TEXT_INPUT = By.id("editText1");
    public static By CHECKBOX_INPUT = By.id("checkBox1");
    public static By POST_BUTTON = By.id("button1");

    public MainActivityPage(AppiumDriver driver){
        this.driver = driver;
    }

    //region Action
    public void clickOnMainMenu(){
        logStep("Click on main menu");
        driver.findElement(MAIN_MENU).click();
    }

    public void clickOnMainMenuItem(int index){
        WebElement item = driver.findElements(MAIN_ITEMS).get(index - 1);
        logStep("Click on main menu item - " + item.getText());
        item.click();
    }

    public void typeToTextInput(String text){
        logStep("Type to edit input - " + text);
        driver.findElement(EDIT_TEXT_INPUT).sendKeys(text);
    }

    public void clickOnRevertCheckBox(){
        logStep("Click on revert checkbox button");
        driver.findElement(CHECKBOX_INPUT).click();
    }

    public void clickOnPostButton(){
        logStep("Click on Post button");
        driver.findElement(POST_BUTTON).click();
    }
    //endregion

    //region Verification
    public void verifyTextInputData(String expectedData){
        assertThat("Text on textView not correct",expectedData, equalTo(driver.findElement(TEXT_INPUT).getText()));
        logPositive(String.format("%s equals %s", expectedData, driver.findElement(TEXT_INPUT).getText()));
    }

    public void verifyStringIsRevert(String expectedData){
        String revertString = new StringBuilder(driver.findElement(TEXT_INPUT).getText()).reverse().toString();
        assertThat("String isn't revert",expectedData, equalTo(revertString));
        logPositive(String.format("String %s is revert", expectedData));
    }
    //endregion
}
