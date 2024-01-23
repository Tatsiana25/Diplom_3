import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordRecoveryPage extends BasePage {

    private WebDriver driver;

    private final By emailField = By.cssSelector("input[name='name']");
    private final By enterLinkButton = By.cssSelector(".Auth_link__1fOlj");

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Шаг: Ожидание загрузки страницы восстановления пароля")
    public void waitLoadRecoveryPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.emailField));
    }

    @Step("Шаг: Нажатие на линк 'Войти'")
    public void enterLinkButtonClick() {
        waitLoadRecoveryPage();
        driver.findElement(this.enterLinkButton).click();
    }

}
