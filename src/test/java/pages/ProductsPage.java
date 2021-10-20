package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

    private static final By TITLE = By.cssSelector(".title");
    public static final By ADD_TO_CART_BACKPACK = By.id("add-to-cart-sauce-labs-backpack");
    public static final By ADD_TO_CART_BIKE_LIGHT = By.id("add-to-cart-sauce-labs-bike-light");
    public static final By ADD_TO_CART_BOLT_T_SHIRT = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    public static final By ADD_TO_CART_FLEECE_JACKET = By.id("add-to-cart-sauce-labs-fleece-jacket");
    public static final By ADD_TO_CART_LABS_ONESIE = By.id("add-to-cart-sauce-labs-onesie");
    public static final By ADD_TO_CART_T_SHIRT_RED = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    public ProductsPage(WebDriver driver){
        super(driver);

    }

    public void open(){
        driver.get(BASE_URL + "/inventory.html");
    }

    public String getHeader(){
        return driver.findElement(TITLE).getText();
    }

    public void addToCart(By elemAddButton) {
        driver.findElement(elemAddButton).click();
    }



}
