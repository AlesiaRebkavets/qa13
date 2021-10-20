package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    private static final By FIRST_NAME_FIELD = By.id("first-name");
    private static final By LAST_NAME_FIELD = By.id("last-name");
    private static final By ZIP_CODE_FIELD = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By FINISH_BUTTON = By.id("finish");
    private static final By TITLE_COMPLETE = By.cssSelector(".title");

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public void Open(){
        driver.get(BASE_URL + "/checkout-step-one.html");
    }

    public String getHeader(){
        return driver.findElement(TITLE_COMPLETE).getText();
    }

    public void enterUsersData(String first_name, String last_name, String zip_code){
        driver.findElement(FIRST_NAME_FIELD).sendKeys(first_name);
        driver.findElement(LAST_NAME_FIELD).sendKeys(last_name);
        driver.findElement(ZIP_CODE_FIELD).sendKeys(zip_code);
    }

    public void pressingContinueButton(){
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void pressingFinishButton(){
        driver.findElement(FINISH_BUTTON).click();
    }





}
