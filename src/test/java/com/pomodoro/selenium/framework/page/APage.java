package com.pomodoro.selenium.framework.page;

import com.pomodoro.selenium.framework.AWebPart;
import com.pomodoro.selenium.framework.element.ANavigationBar;
import org.openqa.selenium.WebDriver;

public abstract class APage<T extends APage<T>> extends AWebPart {

    public static final String ROOT_URL = "https://pomapp-timer.herokuapp.com";

    protected final String url;
    protected final ANavigationBar navigationBar;

    public APage(WebDriver driver, String url, ANavigationBar navigationBar) {
        super(driver);
        this.url = url;
        this.navigationBar = navigationBar;
    }

    public T goTo() {
        driver.get(this.url);
        return (T) this;
    }

    public String getUrl() {
        return url;
    }

    public abstract ANavigationBar getNavigationBar();
}
