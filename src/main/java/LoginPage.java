import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private WebDriver driver;

    private final By emailField = By.cssSelector("input[name='name']");
    private final By passwordField = By.cssSelector("input[name='Пароль']");
    private final By enterButton = By.cssSelector(".Auth_form__3qKeq.mb-20 > .button_button__33qZ0.button_button_size_medium__3zxIa.button_button_type_primary__1O7Bx");
    private final By registrationLink = By.cssSelector(".mb-4.text.text_type_main-default.undefined > .Auth_link__1fOlj");
    private final By recoveryLink = By.cssSelector(".Auth_login__3hAey p:nth-of-type(2) .Auth_link__1fOlj");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    @Step("Шаг: Ввод email в поле ввода")
    public void setEmailField(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.emailField));
        driver.findElement(this.emailField).sendKeys(email);
    }

    @Step("Шаг: Ввод пароля в поле ввода")
    public void setPasswordField(String password) {
        driver.findElement(this.passwordField).sendKeys(password);
    }

    @Step("Шаг: Нажатие на кнопку 'Войти'")
    public void enterButtonClick() {
        driver.findElement(this.enterButton).click();
    }

    @Step("Шаг: Нажатие на ссылку 'Зарегистрироваться'")
    public void registrationLinkClick() {
        driver.findElement(this.registrationLink).click();
    }

    @Step("Шаг: Нажатие на ссылку 'Восстановить пароль'")
    public void recoveryLinkClick() {
        driver.findElement(this.recoveryLink).click();
    }

    @Step("Шаг: Авторизация с email: {0}, паролем: {1}")
    public void login(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        enterButtonClick();
    }
}

