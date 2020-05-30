package com.pomodoro.selenium.framework.page.loggedin;

import com.pomodoro.selenium.framework.element.ANavigationBar;
import com.pomodoro.selenium.framework.element.LoggedInNavigationBar;
import com.pomodoro.selenium.framework.page.APage;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends APage<MyAccountPage> {

    public MyAccountPage(WebDriver driver) {
        super(driver, String.format("%s/my-account/personal-information", ROOT_URL), new LoggedInNavigationBar(driver));
    }

    @Override
    public LoggedInNavigationBar getNavigationBar() {
        return (LoggedInNavigationBar)this.navigationBar;
    }
}
