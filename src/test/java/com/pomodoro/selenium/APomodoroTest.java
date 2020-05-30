package com.pomodoro.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.pomodoro.selenium.framework.page.APage.ROOT_URL;

public abstract class APomodoroTest {

    protected WebDriver webDriver;

    @BeforeEach
    public void beforeEach() {
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.get(ROOT_URL);
        this.webDriver.findElement(By.cssSelector("#frameModalTop > div > div > div > div > a:nth-child(3)")).click();
        new WebDriverWait(webDriver,10).until(ExpectedConditions.invisibilityOfElementLocated(By.id("frameModalTop")));
    }

    @AfterEach
    public void afterEach() {
        webDriver.quit();
    }

}
