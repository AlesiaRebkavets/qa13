package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private static final By TITLE = By.cssSelector(".title"); //+
    public static final By ALL_ELEMENTS_IN_CART = By.xpath("//div[@class='inventory_item_name']");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");   //+
    private static final By LAST_CART_ELEMENT = By.xpath("//div[@class='inventory_item_name'][last()]"); //+
    private static final By REMOVE_BUTTON_OF_LAST_CART_ELEMENT = By.xpath("//button[@class='btn btn_secondary btn_small cart_button'][last()]"); //+
    private static final By CHECKOUT_BUTTON = By.id("checkout");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openURL() {
        driver.get(BASE_URL + "/cart.html");
    }

    public void open() {
        driver.findElement(CART_BUTTON).click();
    }


    public void removeFromCart(By elemRemoveButton) {
        driver.findElement(elemRemoveButton).click();
    }

    public String getHeader() {
        return driver.findElement(TITLE).getText();
    }

    public String getGoodsLabel() {
        return driver.findElement(LAST_CART_ELEMENT).getText();
    }

    public int numberOfElementsInCart() {
        return driver.findElements(ALL_ELEMENTS_IN_CART).size();
    }

    public void removeLastElementFromCart() {
        driver.findElement(REMOVE_BUTTON_OF_LAST_CART_ELEMENT).click();
    }

    public void checkoutGoods(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }



}
