package com.pomodoro.selenium.framework.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicNavigationBar extends ANavigationBar {

    public BasicNavigationBar(WebDriver driver) {
        super(driver);
    }

    public void toHome() {
        driver.findElement(By.cssSelector("#navbarCollapse .links ul.navbar-nav:nth-child(1) > li:nth-child(1) > a")).click();
    }
    public void toFreeTrial() {
        driver.findElement(By.cssSelector("#navbarCollapse .links ul.navbar-nav:nth-child(1) > li:nth-child(2) > a")).click();
    }
    public void toLogin() {
        driver.findElement(By.cssSelector("#navbarCollapse .links ul.navbar-nav:nth-child(2) > li:nth-child(1) > a")).click();
    }
    public void toRegistration() {
        driver.findElement(By.cssSelector("#navbarCollapse .links ul.navbar-nav:nth-child(2) > li:nth-child(2) > a")).click();
    }
}
