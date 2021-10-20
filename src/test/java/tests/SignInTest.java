package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class SignInTest extends  BaseTest{

    @Test
    public void SignIn(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getHeader(), "PRODUCTS", "User is NOT signed in");
    }

    @Test
    public void NegativeUsernameAndPasswordFieldsAreEmpty(){
        loginPage.open();
        loginPage.login("","");
        Assert.assertEquals(loginPage.getError(), "Epic sadface: Username is required", "Error message is not correct");
    }

    @Test
    public void NegativeIncorrectUsername(){
        loginPage.open();
        loginPage.login("abc*/-+", "secret_sauce");
        Assert.assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service", "Error message is not correct");
    }

    @Test
    public void NegativeIncorrectPassword(){
        loginPage.open();
        loginPage.login("standard_user", "abc*/-+");
        Assert.assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service", "Error message is not correct");
    }

}
