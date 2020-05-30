package com.pomodoro.selenium.framework.page.loggedin;

import com.pomodoro.selenium.framework.element.ANavigationBar;
import com.pomodoro.selenium.framework.element.LoggedInNavigationBar;
import com.pomodoro.selenium.framework.page.APage;
import org.openqa.selenium.WebDriver;

public class GroupsPage extends APage<GroupsPage> {


    public GroupsPage(WebDriver driver) {
        super(driver, String.format("%s/group", ROOT_URL), new LoggedInNavigationBar(driver));
    }

    @Override
    public LoggedInNavigationBar getNavigationBar() {
        return (LoggedInNavigationBar)this.navigationBar;
    }
}
