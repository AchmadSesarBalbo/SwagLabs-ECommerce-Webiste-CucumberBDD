package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"contents_wrapper\"]/div[2]")
    private WebElement yourCartLabel;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button")
    private WebElement removeItem;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public String getYourCartLabel() { return yourCartLabel.getText(); }

    public void removeItem() { removeItem.click(); }
}