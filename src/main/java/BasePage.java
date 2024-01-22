import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.UserData.*;

public class BasePage {
    private WebDriver driver;
    WebDriverWait wait;
    private String currentUrl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.currentUrl = driver.getCurrentUrl();
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    private final By constructorButton = By.cssSelector("li:nth-of-type(1) > .AppHeader_header__link__3D_hX > .AppHeader_header__linkText__3q_va.ml-2");
    private final By logoStellarBurgers = By.cssSelector("div > a > svg");
    private final By userPersonalAccountButton = By.cssSelector(".AppHeader_header__nav__g5hnF .AppHeader_header__link__3D_hX:nth-child(3) [class]");
    private final By enterInAccountButton = By.cssSelector(".button_button__33qZ0.button_button_size_large__G21Vg.button_button_type_primary__1O7Bx");

    //Блок Собери бургер
    private final By rollsTabs = By.xpath("//div[@id='root']/div/main/section[1]/div[1]/div[1]");
    private final By saucesTabs = By.cssSelector(".BurgerIngredients_ingredients__1N8v2 [class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']:nth-of-type(2) .text_type_main-default");
    private final By fillingsTabs = By.cssSelector("div:nth-of-type(3) > .text.text_type_main-default");

    private final By firstRoll = By.cssSelector("img[alt='Флюоресцентная булка R2-D3']");
    private final By firstSauces = By.cssSelector("img[alt='Соус Spicy-X']");
    private final By firstFillings = By.cssSelector("ul:nth-of-type(3) > a:nth-of-type(1)");


    @Step("Шаг: Проверка открытия страницы с соответствующим URL {0}'")
    public void checkBaseUrl(String currentUrl) {
        Assert.assertEquals(BASE_URL, currentUrl);
    }

    @Step("Шаг: Проверка открытия страницы с соответствующим URL {0}'")
    public void checkLoginUrl(String currentUrl) {
        Assert.assertEquals(LOGIN_URL, currentUrl);
    }

    @Step("Шаг: Проверка открытия страницы с соответствующим URL {0}'")
    public void checkPersonalAccountProfileUrl(String currentUrl) {
        Assert.assertEquals(PERSONAL_ACCOUNT_PROFILE_URL, currentUrl);
    }

    @Step("Шаг: Нажатие кнопки 'Конструктор'")
    public void constructorButtonClick() {
        driver.findElement(this.constructorButton).click();
    }

    @Step("Шаг: Нажатие на логотип Stellar Burgers")
    public void logoStellarBurgersClick() {
        driver.findElement(this.logoStellarBurgers).click();
    }

    @Step("Шаг: Нажатие на кнопку 'Личный кабинет'")
    public void userPersonalAccountButtonClick() {
        driver.findElement(this.userPersonalAccountButton).click();
    }

    @Step("Шаг: Нажатие на кнопку 'Войти в аккаунт'")
    public void enterInAccountButtonClick() {
        driver.findElement(this.enterInAccountButton).click();
    }

    @Step("Шаг: Нажатие на вкладку 'Булки'")
    public void rollsTabsClick() {
        driver.findElement(this.rollsTabs).click();
    }

    @Step("Шаг: Нажатие на вкладку 'Соусы'")
    public void saucesTabsClick() {
        driver.findElement(this.saucesTabs).click();
    }

    @Step("Шаг: Нажатие на вкладку 'Наполнители'")
    public void fillingsTabsClick() {
        driver.findElement(this.fillingsTabs).click();
    }

    @Step("Шаг: Проверка видимости кнопки 'Оформить заказ'")
    public void checkPlaceAnOrderButtonVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.enterInAccountButton));
        String textInButton = driver.findElement(this.enterInAccountButton).getText();
        Assert.assertEquals("Оформить заказ", textInButton);
    }

    @Step("Шаг: Проверка видимости первой булки")
    public void checkFirstRollVisible() {
        WebElement firstRollElement = driver.findElement(this.firstRoll);
        Assert.assertTrue("First roll is not visible", firstRollElement.isDisplayed());
    }

    @Step("Шаг: Проверка видимости первого соуса")
    public void checkFirstSaucesVisible() {
        WebElement firstSaucesElement = driver.findElement(this.firstSauces);
        Assert.assertTrue("First sauce is not visible", firstSaucesElement.isDisplayed());
    }

    @Step("Шаг: Проверка видимости первой начинки")
    public void checkFirstFillingsVisible() {
        WebElement firstFillingsElement = driver.findElement(this.firstFillings);
        Assert.assertTrue("First filling is not visible", firstFillingsElement.isDisplayed());
    }

}

