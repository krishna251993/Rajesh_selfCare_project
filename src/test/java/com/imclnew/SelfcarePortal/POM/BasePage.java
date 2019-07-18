package com.imclnew.SelfcarePortal.POM;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.imclnew.SelfcarePortal.Utilities.Property;

public class BasePage
{
    public WebDriver driver;
    public Logger logger;
    public long timeout;
    public String configFile;
    

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        logger=Logger.getLogger("LoG file");
        PropertyConfigurator.configure("log4j.properties");
       // timeout=Long.parseLong(Property.getPropertyValue(configFile, "EXPLICIT"));
    
    }

    public void waitTillTheElementVisible(WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
