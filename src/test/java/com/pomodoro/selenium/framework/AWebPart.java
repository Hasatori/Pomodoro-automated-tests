package com.pomodoro.selenium.framework;

import org.openqa.selenium.WebDriver;

public abstract class AWebPart {

    protected final WebDriver driver;

    public AWebPart(WebDriver driver) {
        this.driver = driver;
    }
}
