package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class SignInTest extends  BaseTest{

    @Test(description = "Successful Login")
    public void SignIn(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getHeader(), "PRODUCTS", "User is NOT signed in");
    }

    @DataProvider
    public Object[][] inputLoginData(){
        return new Object[][]{
                {"", "", "Epic sadface: Username is required", "Error message is not correct"},
                {"abc*/-+", "secret_sauce", "Epic sadface: Username and password do not match any user in this service", "Error message is not correct"},
                {"standard_user", "abc*/-+", "Epic sadface: Username and password do not match any user in this service", "Error message is not correct"}
        };
    }

    @Test (dataProvider = "inputLoginData", description = "Negative: invalid sign in data")
    public void NegativeUsernameAndPasswordFieldsAreEmpty(String login, String password, String expError, String expMessage){
        loginPage.open();
        loginPage.login(login,password);
        Assert.assertEquals(loginPage.getError(), expError, expMessage);
    }

}
