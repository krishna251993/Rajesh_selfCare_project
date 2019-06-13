package com.imclnew.SelfcarePortal.Utilities;

import com.imclnew.SelfcarePortal.POM.BasePage;
import com.imclnew.SelfcarePortal.Test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class TypeOfCustomer {

    public WebDriver driver;

    public TypeOfCustomer(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@id='identity']")
    public WebElement identity;

    @FindBy(xpath = "//span[@id='customertype']")
    public WebElement type;

    public static String identitytext;
    public static String typetext;

    public String customerType() throws InterruptedException {
        typetext=type.getText();
        identitytext = identity.getText();

        String typeOfCustomer="";

        System.out.println(identitytext+"\n"+typetext);

        if (typetext.equalsIgnoreCase("NORMAL") && identitytext.equalsIgnoreCase("INDIVIDUAL ACCOUNT"))
        {
            typeOfCustomer="LCO Customer";
        }
        else
        if (typetext.equalsIgnoreCase("PREPAID"))
        {
            if (identitytext.equalsIgnoreCase("INDIVIDUAL ACCOUNT"))
            {
                typeOfCustomer = "DP Prepaid Individual Customer";
            }
            else if (identitytext.equalsIgnoreCase("PARENT ACCOUNT"))
            {
                typeOfCustomer="DP Parent Customer";
            }
            else if (identitytext.equalsIgnoreCase("CHILD ACCOUNT"))
            {
                typeOfCustomer="DP Child Customer";
            }
        }
        return typeOfCustomer;
    }
}