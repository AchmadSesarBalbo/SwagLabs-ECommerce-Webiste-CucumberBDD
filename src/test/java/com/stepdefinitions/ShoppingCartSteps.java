package com.stepdefinitions;

import com.DriverSingleton;
import com.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class ShoppingCartSteps {
    private WebDriver driver;
    private CartPage cartPage;
    private ProductPage productPage;
    private BuyerDataPage buyerDataPage;
    private OverviewPage overviewPage;
    private FinishPage finishPage;

    public ShoppingCartSteps(){
        driver = DriverSingleton.getDriver();
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        buyerDataPage = new BuyerDataPage(driver);
        overviewPage = new OverviewPage(driver);
        finishPage = new FinishPage(driver);

        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("The user is on the Product page")
    public void theUserIsOnTheProductPage() throws InterruptedException {
        Thread.sleep(2000);
        productPage.getProductLabel();
    }

    @When("The user clicks the Cart button")
    public void theUserClicksTheCartButton() throws InterruptedException {
        Thread.sleep(2000);
        productPage.goCart();
        String actual = cartPage.getYourCartLabel();
        String expected = "Your Cart";
        Assert.assertEquals(actual, expected);
    }

    @And("The user clicks the Remove button on a product")
    public void theUserClicksTheRemoveButtonOnAProduct() throws InterruptedException {
        Thread.sleep(2000);
        cartPage.removeItem();
    }

    @Then("The product should be removed from the cart")
    public void theProductShouldBeRemovedFromTheCart() throws InterruptedException {
        Thread.sleep(2000);
        String actual = productPage.getShoppingCartBadge();
        String expected = "5";
        Assert.assertEquals(actual, expected);
    }

    @Given("The user is on the Cart page")
    public void theUserIsOnTheCartPage() throws InterruptedException {
        Thread.sleep(2000);
        String actual = cartPage.getYourCartLabel();
        String expected = "Your Cart";
        Assert.assertEquals(actual, expected);
    }

    @When("The user clicks the Checkout button")
    public void theUserClicksTheCheckoutButton() throws InterruptedException {
        Thread.sleep(2000);
        cartPage.clickCheckout();
    }

    @Then("The user should be redirected to the Checkout Information page")
    public void theUserShouldBeRedirectedToTheCheckoutInformationPage() throws InterruptedException {
        Thread.sleep(2000);
        String actual = overviewPage.getOverviewLabel();
        String expected = "Checkout: Your Information";
        Assert.assertEquals(actual, expected);
    }

    @Given("The user is on the Checkout: Overview page")
    public void theUserIsOnTheCheckoutOverviewPage() throws InterruptedException {
        Thread.sleep(2000);
        String actual = buyerDataPage.getYourInformationLabel();
        String expected = "Checkout: Overview";
        Assert.assertEquals(actual, expected);
        
    }

    @When("The user clicks the Finish button")
    public void theUserClicksTheFinishButton() throws InterruptedException {
        Thread.sleep(2000);
        overviewPage.getFinishButton();
    }

    @Then("The system navigates to the Finish page and displays the message “THANK YOU FOR YOUR ORDER”")
    public void theSystemNavigatesToTheFinishPageAndDisplaysTheMessageTHANKYOUFORYOURORDER() throws InterruptedException {
        Thread.sleep(2000);
        String actual = finishPage.getFinishPage();
        String expected = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actual,expected);
    }
}