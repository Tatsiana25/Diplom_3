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


    public void login(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        enterButtonClick();
    }

    public void setEmailField(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.emailField));
        driver.findElement(this.emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        driver.findElement(this.passwordField).sendKeys(password);
    }

    public void enterButtonClick() {
        driver.findElement(this.enterButton).click();
    }

    public void registrationLinkClick() {
        driver.findElement(this.registrationLink).click();
    }

    public void recoveryLinkClick() {
        driver.findElement(this.recoveryLink).click();
    }
}

