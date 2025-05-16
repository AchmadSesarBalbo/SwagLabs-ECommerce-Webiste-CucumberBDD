package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BuyerDataPage {
    private Actions actions;

    @FindBy(xpath = "//*[@id=\"contents_wrapper\"]/div[2]")
    private WebElement yourInformationLabel;

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/h3")
    private WebElement errorMessage;

    public BuyerDataPage(WebDriver driver) {
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void continueAction(String firstName, String lastName, String zip) {
        actions.click(firstNameField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(firstName)
                .pause(Duration.ofSeconds(1))
                .click(lastNameField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(lastName)
                .pause(Duration.ofSeconds(1))
                .click(postalCode).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(zip)
                .pause(Duration.ofSeconds(1))
                .build().perform();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public String getYourInformationLabel() {
        return yourInformationLabel.getText(); }

    public String getErrorMessage() {
        return errorMessage.getText(); }
}
