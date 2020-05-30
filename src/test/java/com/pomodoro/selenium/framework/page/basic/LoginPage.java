package com.pomodoro.selenium.framework.page.basic;

import com.pomodoro.selenium.framework.element.BasicNavigationBar;
import com.pomodoro.selenium.framework.page.APage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.pomodoro.selenium.Constants.VALID_PASSWORD;
import static com.pomodoro.selenium.Constants.VALID_USERNAME;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends APage<LoginPage> {


    public LoginPage(WebDriver driver) {
        super(driver, String.format("%s/login", ROOT_URL), new BasicNavigationBar(driver));
    }


    public void login(String username, String password) {
        driver.findElement(By.id("elegantFormUsernameEx")).sendKeys(username);
        driver.findElement(By.id("elegantFormPasswordEx")).sendKeys(password);
        driver.findElement(By.xpath("//form/div/button")).submit();
    }


    public void loginWithValidCredentials() {
        login(VALID_USERNAME, VALID_PASSWORD);
        By warningElementSelector = By.xpath("/html/body/app-root/div/app-pomodoro/app-pomodoro-is-running/div/div/div/div[3]/a");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(warningElementSelector));
        driver.findElement(warningElementSelector).click();
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(warningElementSelector));
    }

    @Override
    public BasicNavigationBar getNavigationBar() {
        return (BasicNavigationBar) this.navigationBar;
    }

    public void assertLoginErrorMessageShown() {
        assertTrue(new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/app-root/div/app-login/div/div[2]/section/mdb-card/mdb-card-body/form/div[3]/div"), "Incorrect credentials!")));
    }
    public void assertUsernameEmptyErrorMessageShown() {
        assertTrue(new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("#elegantFormUsernameEx + label .invalid-feedback"), "Username must be filled!")));
    }
    public void assertPasswordEmptyErrorMessageShown() {
        assertTrue(new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("#elegantFormPasswordEx + label .invalid-feedback"), "Password must be filled!")));
    }
}
