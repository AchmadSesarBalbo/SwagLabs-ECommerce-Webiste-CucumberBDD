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

public class CheckoutSteps {
    private WebDriver driver;
    private OverviewPage overviewPage;
    private BuyerDataPage buyerDataPage;
    private FinishPage finishPage;

    public CheckoutSteps() {
        driver = DriverSingleton.getDriver();
        overviewPage = new OverviewPage(driver);
        buyerDataPage = new BuyerDataPage(driver);
        finishPage = new FinishPage(driver);

        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("The user is on the Checkout: Your Information page")
    public void theUserIsOnTheCheckoutYourInformationPage() throws InterruptedException {
        Thread.sleep(2000);
        buyerDataPage.getYourInformationLabel();
    }

    @When("The user enters {string} {string} and {string}")
    public void theUserEntersAndIn(String firsName, String lastName, String postalCode) throws InterruptedException {
        Thread.sleep(2000);
        buyerDataPage.continueAction(firsName, lastName, postalCode);
    }

    @And("The user clicks the Continue button")
    public void theUserClicksTheContinueButton() throws InterruptedException {
        Thread.sleep(2000);
        buyerDataPage.clickContinue();
    }

    @Then("The system displays {string}")
    public void theSystemDisplays(String expectedResult) {
        String actualCount = buyerDataPage.getErrorMessage();
        Assert.assertEquals(actualCount, expectedResult);
    }
}
