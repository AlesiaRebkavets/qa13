package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private static final By USER_NAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR = By.cssSelector("[data-test=error]"); // todo: error displayed after pressing the "Login" button

    public LoginPage(WebDriver driver){
        super(driver);

    }

    public void open(){
        driver.get(BASE_URL);
    }


    public void login(String user, String password){
        driver.findElement(USER_NAME).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

    }

    public String getError(){
        return driver.findElement(ERROR).getText();
    }


}
