import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static data.UserData.*;

public class LoginTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @After
    public void stop() {
        driver.quit();
    }

    @Test
    public void checkLoginFromEnterInAccountButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterInAccountButtonClick();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        loginPage.checkPlaceAnOrderButtonVisible();
    }

    @Test
    public void checkLoginFromUserPersonalAccountButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userPersonalAccountButtonClick();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        loginPage.checkPlaceAnOrderButtonVisible();
    }

    @Test
    public void checkLoginFromEnterLinkButtonInRegistrationPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterInAccountButtonClick();
        loginPage.registrationLinkClick();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickEnterLinkButton();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        loginPage.checkPlaceAnOrderButtonVisible();
    }

    @Test
    public void checkLoginFromPasswordRecoveryPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterInAccountButtonClick();
        loginPage.recoveryLinkClick();
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.enterLinkButtonClick();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        loginPage.checkPlaceAnOrderButtonVisible();
    }

    @Test
    public void checkUnLoginInUserPersonalAccount() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userPersonalAccountButtonClick();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        loginPage.checkPlaceAnOrderButtonVisible();
        loginPage.userPersonalAccountButtonClick();
        new PersonalAccountPage(driver).exitButtonClick();
        loginPage.checkLoginUrl(driver.getCurrentUrl());
    }


}
