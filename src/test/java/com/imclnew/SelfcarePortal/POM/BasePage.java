package com.imclnew.SelfcarePortal.POM;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage
{
    public WebDriver driver;
    public Logger logger;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        logger=Logger.getLogger("LoG file");
        PropertyConfigurator.configure("log4j.properties");
    }

    public void waitTillTheElementVisible(WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
