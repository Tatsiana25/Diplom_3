import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static data.UserData.BASE_URL;

public class RegistrationTests {
    private WebDriver driver;
    private String testUserEmail;
    private String password;
    private String name;

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
    public void checkSuccessfulRegistration() {
        testUserEmail = "test_user_" + System.currentTimeMillis() + "@example.com";
        password = "password" + System.currentTimeMillis();
        name = "name" + System.currentTimeMillis();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterInAccountButtonClick();
        loginPage.registrationLinkClick();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(testUserEmail, password, name);

        new LoginPage(driver).login(testUserEmail, password);
        loginPage.checkBaseUrl(loginPage.getCurrentUrl());
        registrationPage.deleteUser(testUserEmail, password, name);
    }

    @Test
    public void checkInvalidPasswordError() {
        testUserEmail = "test_user_" + System.currentTimeMillis() + "@example.com";
        password = "123";
        name = "name" + System.currentTimeMillis();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterInAccountButtonClick();
        loginPage.registrationLinkClick();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(testUserEmail, password, name);

        // Проверка наличия ошибки для некорректного пароля
        String errorText = registrationPage.getErrorStatus();
        Assert.assertEquals("Некорректный пароль", errorText);
    }
}
