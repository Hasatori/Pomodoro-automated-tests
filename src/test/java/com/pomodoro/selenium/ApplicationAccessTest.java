package com.pomodoro.selenium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ApplicationAccessTest extends APomodoroTest {


    @ParameterizedTest
    @MethodSource(value = "provideAllWebDrivers")
    public void loginTest_CorrectCredentials_ShouldLogin(Browser browser) {
        webDriver = webDriverFactory.getWebdriver(browser);
        loginValidCredentials();
        assertEquals("https://pomapp-timer.herokuapp.com/pomodoro", webDriver.getCurrentUrl());
    }

    @ParameterizedTest
    @MethodSource(value = "provideAllWebDrivers")
    public void loginTest_InCorrectCredentials_ErrorMessageShouldBeShown(Browser browser) {
        webDriver = webDriverFactory.getWebdriver(browser);
        login("INCORRECT_USERNAME", "INCORRECT_PASSWORD");
        String messageXpath = "//app-login/div/div[2]/section/mdb-card/mdb-card-body/form/div[3]/div";
        assertTrue(getWait().until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(messageXpath), "Incorrect credentials!")));
    }

    @ParameterizedTest
    @MethodSource(value = "provideAllExceptForFirefoxWebDrivers")
    public void logoutTest_LogoutLinkClicked_ShouldLogOut(Browser browser) {
        webDriver = webDriverFactory.getWebdriver(browser);
        loginValidCredentials();
        removeOverlayWindows(webDriver);
        logout(webDriver);
        assertEquals("https://pomapp-timer.herokuapp.com/login", webDriver.getCurrentUrl());
    }

    private void removeOverlayWindows(WebDriver webDriver) {
        String appIsRunningWarningXpath = "//app-pomodoro-is-running/div/div/div/div[3]/a";
        webDriver.findElement(By.xpath(appIsRunningWarningXpath)).click();
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(appIsRunningWarningXpath)));
    }

}
