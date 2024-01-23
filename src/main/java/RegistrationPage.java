import data.UserData;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.restassured.response.Response;

public class RegistrationPage {
    private WebDriver driver;

    private final By nameField = By.cssSelector("fieldset:nth-of-type(1) > .input__container > .input.input_size_default.input_type_text.pl-6.pr-6 > input[name='name']");
    private final By emailField = By.cssSelector("fieldset:nth-of-type(2) > .input__container > .input.input_size_default.input_type_text.pl-6.pr-6 > input[name='name']");
    private final By passwordField = By.cssSelector("input[name='Пароль']");
    private final By errorStatus = By.cssSelector(".input__error.text_type_main-default");
    private final By registrationButton = By.cssSelector(".Auth_form__3qKeq.mb-20 > .button_button__33qZ0.button_button_size_medium__3zxIa.button_button_type_primary__1O7Bx");
    private final By enterLinkButton = By.cssSelector(".Auth_link__1fOlj");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Шаг: Регистрация пользователя с email: {0}, password: {1}, name: {2}")
    public void registration(String email, String password, String name) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickRegistrationButton();
    }

    @Step("Шаг: Ввод имени в поле")
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Шаг: Ввод email в поле")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Шаг: Ввод пароля в поле")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Шаг: Получение текста ошибки")
    public String getErrorStatus() {
        WebElement errorElement = driver.findElement(errorStatus);
        return errorElement.getText();
    }

    @Step("Шаг: Нажатие на кнопку регистрации")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Шаг: Нажатие на ссылку входа")
    public void clickEnterLinkButton() {
        driver.findElement(enterLinkButton).click();
    }

    @Step("Шаг: Удаление пользователя с параметрами - email: {0}, password: {1}, name: {2}")
    static Response deleteUser(String email, String password, String name) {
        RestAssured.baseURI = UserData.DELETE_URL;
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"name\":\"" + name + "\"}")
                .delete();
    }
}
