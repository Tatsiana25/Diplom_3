import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static data.UserData.*;

public class GoToTabsTests {
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
    public void checkGoToPersonalAccountTabAndLogoTabAndConstructorTab() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userPersonalAccountButtonClick();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        loginPage.checkPlaceAnOrderButtonVisible();
        loginPage.userPersonalAccountButtonClick();
        new PersonalAccountPage(driver).checkVisibleButtonClick();
        loginPage.checkPersonalAccountProfileUrl(driver.getCurrentUrl());
        loginPage.userPersonalAccountButtonClick();
        loginPage.logoStellarBurgersClick();
        loginPage.checkBaseUrl(driver.getCurrentUrl());
        loginPage.userPersonalAccountButtonClick();
        loginPage.constructorButtonClick();
        loginPage.checkBaseUrl(driver.getCurrentUrl());
    }

    @Test
    public void checkGoToRollsTabSaucesTabsFillingsTabs() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.saucesTabsClick();
        loginPage.checkFirstSaucesVisible();
        loginPage.fillingsTabsClick();
        loginPage.checkFirstFillingsVisible();
        loginPage.rollsTabsClick();
        loginPage.checkFirstRollVisible();
    }
}
