package com.pomodoro.selenium;

import com.pomodoro.selenium.framework.element.BasicNavigationBar;
import com.pomodoro.selenium.framework.element.LoggedInNavigationBar;
import com.pomodoro.selenium.framework.page.basic.FreeTrial;
import com.pomodoro.selenium.framework.page.basic.HomePage;
import com.pomodoro.selenium.framework.page.basic.LoginPage;
import com.pomodoro.selenium.framework.page.basic.RegistrationPage;
import com.pomodoro.selenium.framework.page.loggedin.GroupsPage;
import com.pomodoro.selenium.framework.page.loggedin.MyAccountPage;
import com.pomodoro.selenium.framework.page.loggedin.PomodoroPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class NavigationBarTest extends APomodoroTest {


    @Test
    public void basicNavigationBarTest_TryAllLinks_UrlShouldBeCorrect() {
        BasicNavigationBar navigationBar = new BasicNavigationBar(webDriver);

        navigationBar.toHome();
        String homeUrl = webDriver.getCurrentUrl();

        navigationBar.toFreeTrial();
        String freeTrialUrl = webDriver.getCurrentUrl();

        navigationBar.toLogin();
        String loginUrl = webDriver.getCurrentUrl();

        navigationBar.toRegistration();
        String registrationUrl = webDriver.getCurrentUrl();

        assertAll(
                () -> assertEquals(new HomePage(webDriver).getUrl(), homeUrl),
                () -> assertEquals(new FreeTrial(webDriver).getUrl(), freeTrialUrl),
                () -> assertEquals(new LoginPage(webDriver).getUrl(), loginUrl),
                () -> assertEquals(new RegistrationPage(webDriver).getUrl(), registrationUrl)
        );

    }

    @Test
    public void loggedInNavigationBarTest_TryAllLinks_UrlShouldBeCorrect() {
        new LoginPage(webDriver).goTo().loginWithValidCredentials();
        LoggedInNavigationBar navigationBar = new LoggedInNavigationBar(webDriver);

        navigationBar.toPomodoro();
        String pomodoroUrl = webDriver.getCurrentUrl();

        navigationBar.toGroups();
        String groupsUrls = webDriver.getCurrentUrl();

        navigationBar.toMyAccount();
        String myAccountUrl = webDriver.getCurrentUrl();

        navigationBar.logOut();
        String logOutUrl = webDriver.getCurrentUrl();

        assertAll(
                () -> assertEquals(new PomodoroPage(webDriver).getUrl(), pomodoroUrl),
                () -> assertEquals(new GroupsPage(webDriver).getUrl(), groupsUrls),
                () -> assertEquals(new MyAccountPage(webDriver).getUrl(), myAccountUrl),
                () -> assertEquals(new LoginPage(webDriver).getUrl(), logOutUrl)
        );

    }
}
