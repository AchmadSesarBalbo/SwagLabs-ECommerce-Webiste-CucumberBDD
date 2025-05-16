package com.stepdefinitions;

import com.DriverSingleton;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utils.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    @Given("The user opens the login page")
    public void setLoginSteps(){
        driver = DriverSingleton.getDriver();
        driver.get(Browser.URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @When("I login with valid credentials {string} and {string}")
    public void iLoginWithValidCredentialsAnd(String username, String password) throws InterruptedException {
        loginPage.loginAction(username, password);
        Thread.sleep(2000);
        loginPage.clickLogin();
    }

    @Then("I should see the products page")
    public void iShouldSeeTheProductsPage() throws InterruptedException {
        Thread.sleep(2000);
        String actual = productPage.getProductLabel();
        String expected = "Products";
        Assert.assertEquals(actual, expected);
    }

    @When("I login with invalid credentials {string} and {string}")
    public void iLoginWithInvalidCredentialsAnd(String username, String password) throws InterruptedException {
        loginPage.loginAction(username, password);
        Thread.sleep(2000);
        loginPage.clickLogin();
    }

    @Then("I should see error message {string}")
    public void iShouldSeeErrorMessage(String error_message) throws InterruptedException {
        Thread.sleep(2000);
        String actualCount = loginPage.getErrorMessage();
        Assert.assertEquals(actualCount, error_message);
    }
}
