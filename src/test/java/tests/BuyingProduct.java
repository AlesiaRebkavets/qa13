package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyingProduct extends BaseTest{


    @Test
    public void openCart(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        cartPage.open();
        Assert.assertEquals(cartPage.getHeader(), "YOUR CART", "Wrong page is opened");


    }

    @Test
    public void addElementToCart(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(productsPage.ADD_TO_CART_BACKPACK);
        cartPage.open();
        Assert.assertEquals(cartPage.getGoodsLabel(), "Sauce Labs Backpack", "The good wasn't added to the card");
    }

    @Test
    public void addAllElementsToCart(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(productsPage.ADD_TO_CART_BACKPACK);
        productsPage.addToCart(productsPage.ADD_TO_CART_BIKE_LIGHT);
        productsPage.addToCart(productsPage.ADD_TO_CART_BOLT_T_SHIRT);
        productsPage.addToCart(productsPage.ADD_TO_CART_FLEECE_JACKET);
        productsPage.addToCart(productsPage.ADD_TO_CART_LABS_ONESIE);
        productsPage.addToCart(productsPage.ADD_TO_CART_T_SHIRT_RED);
        cartPage.open();
        Assert.assertEquals(cartPage.numberOfElementsInCart(), 6, "The number of elements in cart doesn't correspond to the number of added goods");
    }

    @Test
    public void removeLastElementFromCart(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(productsPage.ADD_TO_CART_BACKPACK);
        productsPage.addToCart(productsPage.ADD_TO_CART_BIKE_LIGHT);
        productsPage.addToCart(productsPage.ADD_TO_CART_BOLT_T_SHIRT);
        productsPage.addToCart(productsPage.ADD_TO_CART_FLEECE_JACKET);
        productsPage.addToCart(productsPage.ADD_TO_CART_LABS_ONESIE);
        productsPage.addToCart(productsPage.ADD_TO_CART_T_SHIRT_RED);
        cartPage.open();
        cartPage.removeLastElementFromCart();
        Assert.assertEquals(cartPage.numberOfElementsInCart(),5, "The number of elements in cart doesn't correspond to the number of added goods");
    }

    @Test
    public void buyingGoods(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart(productsPage.ADD_TO_CART_BACKPACK);
        productsPage.addToCart(productsPage.ADD_TO_CART_BIKE_LIGHT);
        cartPage.open();
        cartPage.checkoutGoods();
        checkoutPage.enterUsersData("name", "lname", "45278");
        checkoutPage.pressingContinueButton();
        checkoutPage.pressingFinishButton();
        Assert.assertEquals(checkoutPage.getHeader(), "CHECKOUT: COMPLETE!", "Product purchase is not completed");
    }



}
