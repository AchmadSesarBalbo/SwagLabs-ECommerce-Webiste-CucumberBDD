package com.stepdefinitions;

import com.DriverSingleton;
import com.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class ProductSteps {
    private WebDriver driver;
    private ProductPage productPage;

    public ProductSteps(){
        driver = DriverSingleton.getDriver();
        productPage = new ProductPage(driver);

        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("The user is logged in and on the Product page")
    public void theUserIsLoggedInAndOnTheProductPage() throws InterruptedException {
        Thread.sleep(2000);
        productPage.getProductLabel();
    }

    @When("The user clicks on a product")
    public void theUserClicksOnAProduct() throws InterruptedException {
        Thread.sleep(2000);
        productPage.viewProduct(0);
    }

    @Then("The system displays the product detail page")
    public void theSystemDisplaysTheProductDetailPage() throws InterruptedException {
        Thread.sleep(2000);
        String actual = productPage.getProductName();
        String expected = "Sauce Labs Backpack";
        Assert.assertEquals(actual, expected);
        Thread.sleep(2000);
        productPage.goBack();
    }

    @When("The user clicks the Add to cart button on a product")
    public void theUserClicksTheAddToCartButtonOnAProduct() throws InterruptedException {
        Thread.sleep(2000);
        productPage.addToCart(0);
    }

    @Then("The cart badge displays the number {string}")
    public void theCartBadgeDisplaysTheNumber(String expectedCount) throws InterruptedException {
        Thread.sleep(2000);
        String actualCount = productPage.getShoppingCartBadge();
        Assert.assertEquals(actualCount, expectedCount);
    }

    @When("The user clicks the Add to cart button on all products")
    public void theUserClicksTheAddToCartButtonOnAllProducts() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            Thread.sleep(2000);
            productPage.addToCart(i);
        }
    }
}
