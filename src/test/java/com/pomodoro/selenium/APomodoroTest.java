package com.pomodoro.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public abstract class APomodoroTest {
    protected static String LOGIN_PAGE = "https://pomapp-timer.herokuapp.com/login";
    protected static String VALID_USERNAME = "Hasatori";
    protected static String VALID_PASSWORD = "test";

    protected WebDriver webDriver;
    protected static WebDriverFactory webDriverFactory = new WebDriverFactory();


    @AfterEach
    public void afterEach() {
        webDriver.quit();
    }

    protected void loginValidCredentials() {
        login(VALID_USERNAME, VALID_PASSWORD);
        getWait().until(ExpectedConditions.urlToBe("https://pomapp-timer.herokuapp.com/pomodoro"));
    }

    protected void login(String username, String password) {
        webDriver.get(LOGIN_PAGE);
        webDriver.findElement(By.xpath("//app-accept-cookies/div/div/div/div/div/a[2]")).click();
        webDriver.findElement(By.id("elegantFormUsernameEx")).sendKeys(username);
        webDriver.findElement(By.id("elegantFormPasswordEx")).sendKeys(password);
        webDriver.findElement(By.xpath("//form/div/button")).submit();

    }

    protected void logout(WebDriver webDriver) {
        webDriver.findElement(By.xpath("//app-root/app-navbar/mdb-navbar/nav/div[2]/links/ul[2]/li[2]/a")).click();
    }

    protected static Stream<Arguments> provideAllWebDrivers() {
        return Arrays.stream(Browser.values()).map(Arguments::of);
    }

    protected static Stream<Arguments> provideAllExceptForFirefoxWebDrivers() {
        return Arrays.stream(Browser.values()).filter(webdriver -> webdriver != Browser.FIREFOX).map(Arguments::of);
    }

    protected WebDriverWait getWait() {
        return new WebDriverWait(webDriver, 5);
    }
}
