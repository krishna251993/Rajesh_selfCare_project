package com.imclnew.SelfcarePortal.POM;

import com.imclnew.SelfcarePortal.Utilities.CustomerIDType;
import com.imclnew.SelfcarePortal.Utilities.TypeOfCustomer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.imclnew.SelfcarePortal.Test.BaseTest.*;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='type']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='userpassword']")
    public WebElement password;
    @FindBy(xpath = "//*[@id=\"login\"]/button")
    public WebElement proceed;
    @FindBy(xpath = "//p[text()='Authentication Failed']")
    public WebElement Auth;
    @FindBy(name = "Smart Card Number")
    public static WebElement smartCardNumber;
    @FindBy(name = "Customer Account Number")
    public static WebElement customerAccountNumber;
    @FindBy(name = "STB Number")
    public static WebElement stbNumber;
    @FindBy(xpath = "//select[@type='text']")
    public static WebElement authenticateUsingSelect;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/p/div")
    public WebElement Error;
    @FindBy(xpath="//*[@id=\"login\"]/h4")
    public WebElement LoginHeader;

    @FindBy(xpath = "//*[@id=\"otp-form\"]/h4[1]")
    private WebElement OTPpendingerror;

    @FindBy(xpath = "//span[@id='customertype']")
    public WebElement type;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String verifyPageTitle()
    {
        logger.info("verifying Login Page header");
        String header = LoginHeader.getText();
        logger.info(header+" is the header");
        return header;
    }
    public void setAuthenticateUsingSelect() throws IOException {
        //waitTillTheElementVisible(authenticateUsingSelect);
        /*check the number is STB or SMC or CAN*/
        Select select = new Select(authenticateUsingSelect);
        select.selectByVisibleText(CustomerIDType.getUserLoginType(un));
        logger.info("AuthenticateUsingSelect has selected");
    }
    public void setUsername() throws IOException {
        logger.info("Entering UserName---"+un);
        username.sendKeys(un);
    }
    public void setPassword() throws IOException {
        logger.info("Entering Password---"+pw);
        password.sendKeys(pw);
    }
    public void clickLoginButton() {
        logger.info("Clicking on Password");
        proceed.click();
    }
    public void verifyPage() throws InterruptedException {
        logger.info("Verifying page");
        TypeOfCustomer toc=new TypeOfCustomer(driver);
        waitTillTheElementVisible(type);
        toc.customerType();
    }
    /*public String errorMsg()
    {
        String mgs="";
        try {
            Thread.sleep(1000);
            if (Error.isDisplayed())
            {
                logger.info("Got some error while login");
                mgs=Error.getText();
                logger.info("error message is "+mgs);
                return mgs;
            }
            else
                Thread.sleep(1000);
                if(OTPpendingerror.isDisplayed())
                {
                    logger.info("error message is "+mgs);
                    mgs=OTPpendingerror.getText();
                }
        }catch (Exception E)
        {
        }
        return mgs;
    }*/
}