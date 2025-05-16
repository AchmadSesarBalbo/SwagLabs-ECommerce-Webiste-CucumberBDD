package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    @FindBy(className = "product_label")
    private WebElement productLabel;

    @FindBy(className = "shopping_cart_container")
    private WebElement shoppingCartBadge;

    @FindBy(className = "btn_inventory")
    private List<WebElement> addproductButton;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productdetailButton;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div/div[1]")
    private WebElement productNameDetail;

    @FindBy(className = "shopping_cart_container")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/button")
    private WebElement backButton;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getProductLabel() {
        return productLabel.getText();
    }

    public String getShoppingCartBadge() {
        return shoppingCartBadge.getText();
    }

    public void addToCart(int index) {
        addproductButton.get(index).click();
    }

    public void viewProduct(int index) {
        productdetailButton.get(index).click();
    }

    public void goCart() {
        cartButton.click();
    }

    public void goBack() {
        backButton.click();
    }

    public String getProductName(){
        return productNameDetail.getText();
    }
}
