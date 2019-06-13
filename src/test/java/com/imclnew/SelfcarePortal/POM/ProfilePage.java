package com.imclnew.SelfcarePortal.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"detail-form\"]/div[6]/input")
    private WebElement emailTextfield;

    @FindBy(xpath = "//*[@id=\"update\"]")
    private WebElement updateButton;

    public void update()
    {
        emailTextfield.clear();
        emailTextfield.sendKeys("akshatha.kv@mobiotics.com");
        updateButton.click();
    }
}