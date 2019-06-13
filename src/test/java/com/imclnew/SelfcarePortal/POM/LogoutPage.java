package com.imclnew.SelfcarePortal.POM;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LogoutPage extends BasePage {
    public LogoutPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[8]/a")
    private WebElement LogoutHeader;

    public void LogoutFromPortal()
    {
        LogoutHeader.click();
    }
}
