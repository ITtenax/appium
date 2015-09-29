package com.saucelabs.appium;

import com.saucelabs.appium.core.TestReporter;

import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;

public class AndroidTest extends BaseTest{

    @Test(dataProvider = "localeProvider")
    public void test_01(String item){
        TestReporter.logTestTitle("Verify text field");
        mainActivityPage.clickOnMainMenu();
        mainActivityPage.clickOnMainMenuItem(parseInt(item));
        mainActivityPage.verifyTextInputData(item);
    }

    @Test
    public void test_02(){
        TestReporter.logTestTitle("Verify edit input");
        mainActivityPage.typeToTextInput(CONSTANT_TEXT);
        mainActivityPage.clickOnPostButton();
        mainActivityPage.verifyTextInputData(CONSTANT_TEXT);
        mainActivityPage.clickOnRevertCheckBox();
        mainActivityPage.clickOnPostButton();
        mainActivityPage.verifyStringIsRevert(CONSTANT_TEXT);
    }
}