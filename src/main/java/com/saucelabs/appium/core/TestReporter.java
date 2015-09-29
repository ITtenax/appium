package com.saucelabs.appium.core;

import org.testng.Reporter;

/**
 * User: Valentyn_Kvasov
 * Date: 28.09.2015
 * Time: 23:44
 */

public class TestReporter {
    public synchronized static void logTestTitle(String message) {
        Reporter.log(String.format(ReporterConstants.HEADER_REPORTER_TITLE, message));
        System.out.println(message);
    }
    public synchronized static void logStep(String message) {
        Reporter.log(String.format(ReporterConstants.STEP, message));
        System.out.println(message);
    }
    public synchronized static void logNegative(String message) {
        Reporter.log(String.format(ReporterConstants.NEGATIVE, message));
        System.out.println(message);
    }
    public synchronized static void logPositive(String message) {
        Reporter.log(String.format(ReporterConstants.POSITIVE, message));
        System.out.println(message);
    }
}
