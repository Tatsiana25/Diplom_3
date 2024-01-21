import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalAccountPage extends BasePage {

    WebDriver driver;
    private final By exitButton = By.cssSelector(".Account_button__14Yp3.text.text_type_main-medium");

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void exitButtonClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.exitButton));
        driver.findElement(this.exitButton).click();
    }
}

