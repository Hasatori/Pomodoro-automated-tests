package com.pomodoro.selenium.framework.page.basic;

import com.pomodoro.selenium.framework.element.ANavigationBar;
import com.pomodoro.selenium.framework.element.BasicNavigationBar;
import com.pomodoro.selenium.framework.page.APage;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends APage<RegistrationPage> {

    public RegistrationPage(WebDriver driver) {
        super(driver, String.format("%s/register", ROOT_URL), new BasicNavigationBar(driver));
    }

    @Override
    public BasicNavigationBar getNavigationBar() {
        return (BasicNavigationBar) this.navigationBar;
    }
}
