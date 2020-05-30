package com.pomodoro.selenium;

import com.pomodoro.selenium.framework.page.basic.LoginPage;
import com.pomodoro.selenium.framework.page.loggedin.PomodoroPage;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.pomodoro.selenium.Constants.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Execution(ExecutionMode.CONCURRENT)
public class LoginTest extends APomodoroTest {

    @ParameterizedTest
    @MethodSource(value = "provideInvalidUsernameAndPasswordInputs")
    public void loginTest_InvalidUsernameOrPassword_ShouldNotLogInAndInvalidCredentialsErrorMessageShouldBeShown(String username, String password) {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(username, password);
        assertAll(
                () -> assertNotEquals(new PomodoroPage(webDriver).getUrl(), webDriver.getCurrentUrl()),
                loginPage::assertLoginErrorMessageShown
        );

    }

    public static Stream<Arguments> provideInvalidUsernameAndPasswordInputs() {
        return Stream.of(
                Arguments.of(INVALID_USERNAME, VALID_PASSWORD),
                Arguments.of(VALID_USERNAME, INVALID_PASSWORD),
                Arguments.of(INVALID_USERNAME, INVALID_PASSWORD)
        );
    }

    @ParameterizedTest(name = "{index} Username: \"{0}\", Password:\"{2}\" ")
    @MethodSource(value = "provideEmptyUsernameOrPasswordInputs")
    public void loginTest_EmptyUsernameOrPassword_ShouldNotLogInAndEmptyErrorMessageShouldBeShown(String username, Boolean shouldCheckUsernameEmptyErrorMessage, String password, Boolean shouldCheckPasswordEmptyErrorMessage) {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(username, password);
        assertAll(
                () -> assertNotEquals(new PomodoroPage(webDriver).getUrl(), webDriver.getCurrentUrl()),
                () -> {
                    if (shouldCheckUsernameEmptyErrorMessage) {
                        loginPage.assertUsernameEmptyErrorMessageShown();
                    }
                },
                () -> {
                    if (shouldCheckPasswordEmptyErrorMessage) {
                        loginPage.assertPasswordEmptyErrorMessageShown();
                    }
                }
        );

    }

    public static Stream<Arguments> provideEmptyUsernameOrPasswordInputs() {
        return Stream.of(
                Arguments.of(EMPTY_STRING, true, VALID_PASSWORD, false),
                Arguments.of(VALID_USERNAME, false, EMPTY_STRING, true),
                Arguments.of(EMPTY_STRING, true, EMPTY_STRING, true)
        );
    }
}
