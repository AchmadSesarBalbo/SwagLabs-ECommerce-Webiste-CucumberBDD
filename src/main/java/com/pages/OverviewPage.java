package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]\n")
    private WebElement finishButton;

    @FindBy(xpath = "//*[@id=\"contents_wrapper\"]/div[2]")
    private WebElement overviewLabel;

    public OverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getOverviewLabel() {
        return overviewLabel.getText();
    }

    public void getFinishButton() {
        finishButton.click();
    }
}
