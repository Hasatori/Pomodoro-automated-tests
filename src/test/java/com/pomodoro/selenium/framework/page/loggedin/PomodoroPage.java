package com.pomodoro.selenium.framework.page.loggedin;

import com.pomodoro.selenium.framework.element.LoggedInNavigationBar;
import com.pomodoro.selenium.framework.page.APage;
import org.openqa.selenium.WebDriver;

public class PomodoroPage extends APage<PomodoroPage> {

    public PomodoroPage(WebDriver driver) {
        super(driver, String.format("%s/pomodoro", ROOT_URL), new LoggedInNavigationBar(driver));
    }

    @Override
    public LoggedInNavigationBar getNavigationBar() {
        return (LoggedInNavigationBar) this.navigationBar;
    }
}
