package com.pomodoro.selenium.framework.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInNavigationBar extends ANavigationBar {
    public LoggedInNavigationBar(WebDriver driver) {
        super(driver);
    }


    public void toPomodoro() {
        driver.findElement(By.cssSelector("#navbarCollapse .links ul.navbar-nav:nth-child(1) > li:nth-child(1) > a")).click();
    }
    public void toGroups() {
        driver.findElement(By.cssSelector("#navbarCollapse .links ul.navbar-nav:nth-child(1) > li:nth-child(2) > a")).click();
    }
    public void toMyAccount() {
        driver.findElement(By.cssSelector("#navbarCollapse .links ul.navbar-nav:nth-child(2) > li:nth-child(1) > a")).click();
    }
    public void logOut() {
        driver.findElement(By.cssSelector("#navbarCollapse .links ul.navbar-nav:nth-child(2) > li:nth-child(2) > a")).click();
    }
}
