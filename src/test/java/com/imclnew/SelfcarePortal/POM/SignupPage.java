package com.imclnew.SelfcarePortal.POM;

import com.imclnew.SelfcarePortal.Utilities.CustomerIDType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static com.imclnew.SelfcarePortal.Test.BaseTest.*;

public class SignupPage extends BasePage {
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/a[2]")
    public WebElement RegisterLink;

    @FindBy(xpath = "//select[@type='text']")
    public static WebElement authenticateUsingSelect;

    @FindBy(xpath="//*[@id=\"type\"]")
    public WebElement CustomerTextField;

    @FindBy(xpath="//*[@id=\"nextButton\"]")
    public WebElement NextButton;

    @FindBy(xpath = "//*[@id=\"customeridholder\"]")
    public WebElement SignUpCustomerIdField;

    @FindBy(xpath="//*[@id=\"password\"]")
    public WebElement Password;

    @FindBy(xpath = "//*[@id=\"confpassword\"]")
    public WebElement ConfirmPassword;

    @FindBy(xpath = "//*[@id=\"mobileno\"]")
    public WebElement MobileNo;

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement Email;

    @FindBy(xpath = "//*[@id=\"signupButton\"]")
    public WebElement SignUpButton;

    @FindBy(xpath = "//*[@id=\"signup-form\"]/div[1]/p[1]")
    public WebElement Errmgs;

    @FindBy(xpath = "/html/body/div[1]")
    private WebElement OTPErrormgs;

    @FindBy(xpath = "//*[@id=\"resendotpveri\"]")
    private WebElement ResendOTP;

    @FindBy(xpath = "//*[@id=\"otp-form\"]/h4")
    private WebElement OTPHeader;

    @FindBy(xpath = "//*[@id=\"otp-form\"]/div[2]/input")
    private WebElement OTPTextfield;

    @FindBy(xpath ="//*[@id=\"otp-form\"]/button")
    private WebElement VerifyButton;

    public SignupPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void Register_To_Selfcare_Portal()
    {
        waitTillTheElementVisible(authenticateUsingSelect);
        /*check the number is STB or SMC or CAN*/
        Select select = new Select(authenticateUsingSelect);
        select.selectByVisibleText(CustomerIDType.getUserLoginType(un));
        CustomerTextField.sendKeys(un);
        NextButton.click();
    }

    public void SignUp() throws InterruptedException {
        Thread.sleep(1000);
        //waitTillTheElementVisible(Password);
        Password.sendKeys(pw);
        ConfirmPassword.sendKeys(pw);
        MobileNo.clear();
        MobileNo.sendKeys(MobNo);
        Email.clear();
        Email.sendKeys(Email_id);
        SignUpButton.click();
        Thread.sleep(1000);
        if(Errmgs.isDisplayed())
            {
                System.out.println(Errmgs.getText());
            }
    }

    public void OTP() throws InterruptedException
    {
        Assert.assertEquals(OTPHeader.getText(),"Enter OTP","Header Mismatch");

        if(OTPErrormgs.isDisplayed())
        {
            ResendOTP.click();
        }
            Thread.sleep(1000);
            OTPTextfield.click();
            Thread.sleep(10000);
            VerifyButton.click();
    }
}