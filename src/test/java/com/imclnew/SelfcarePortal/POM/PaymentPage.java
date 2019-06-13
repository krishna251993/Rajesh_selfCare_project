package com.imclnew.SelfcarePortal.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

import static com.imclnew.SelfcarePortal.Test.BaseTest.*;

public class PaymentPage extends BasePage {
    @FindBy(xpath = "/html/body/div[4]/div[1]/div/h3")
    private WebElement PaymentHeader;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[3]/h3")
    private WebElement PaymentPageHeader;

    @FindBy(xpath = "//*[@id=\"addcredit\"]/div[2]/input")
    private WebElement AmountTextField;

    @FindBy(xpath = "//*[@id=\"addcredit\"]/div[3]/label/input")
    private WebElement Paytm;

    @FindBy(xpath = "//*[@id=\"addcredit\"]/div[4]/label/input")
    private WebElement Mobikwik;

    @FindBy(xpath = "//*[@id=\"addcredit\"]/div[5]/button")
    private WebElement PayButton;

    @FindBy(xpath = "//*[@id=\"cn1\"]")
    private WebElement PaytmDebitCardTextField;

    @FindBy(xpath = "//*[@id=\"dcExpMonth\"]")
    private WebElement ExpiryMonthDropdown;

    @FindBy(xpath = "//*[@id=\"dcCvvBox\"]")
    private WebElement CVVTextfield;

    @FindBy(xpath = "//*[@id=\"dcExpYear\"]")
    private WebElement ExpiryYearDropdown;

    @FindBy(xpath = "//*[@id=\"dcSubmit\"]")
    private WebElement PaytmPayNowButtom;

    @FindBy(xpath = "//*[@id=\"OTP\"]")
    private WebElement PaytmOTPTextfield;

    @FindBy(xpath = "//*[@id=\"waiting_payment\"]/div/div[1]/div[2]/input")
    private WebElement OTPSubmitButton;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/button[2]/span")
    private WebElement successButton;

    @FindBy(xpath = "//*[@id=\"securitytop\"]/div/img[3]")
    private WebElement TPSLPaynimoIcon;

    @FindBy(xpath = "/html/body/div/div/h3")
    private WebElement PaymentStatus;

    @FindBy(xpath = "//*[@id=\"redirect_link\"]")
    private WebElement redirectPage;

    @FindBy(xpath = "//*[@id=\"balance\"]")
    private WebElement WalletBalance;

    @FindBy(xpath = "//*[@id=\"walletbalance\"]")
    private WebElement updatedWalletBalance;

    @FindBy(xpath = "//*[@id=\"close\"]")
    private WebElement MobikwikCancelButton;

    @FindBy(xpath = "//*[@id=\"redirect_link\"]")
    private WebElement GoToAddCreditPageButton;



    public float amount;
    public float walletamount;
    public float updatedWalletAmount;

    public PaymentPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String PageVerification()
    {
        String Header=PaymentPageHeader.getText();
        return Header;
    }

    public void Recharge() throws InterruptedException {
        walletamount=Float.valueOf(WalletBalance.getText());
        Random rand=new Random();
        amount= rand.nextInt(5);
        if(amount==0){amount++;}
        int round=(int)amount;
            logger.info(round+"---------amount");
        String changes=Integer.toString(round);
        Thread.sleep(1000);
        AmountTextField.clear();
        AmountTextField.sendKeys(changes);
        Thread.sleep(1000);
        Paytm.click();
        PayButton.click();
    }

    public void PaymentGateway() throws InterruptedException {
        try {
            Thread.sleep(1000);
            if(TPSLPaynimoIcon.isEnabled()|| TPSLPaynimoIcon.isDisplayed())
            {
                driver.navigate().back();
                Thread.sleep(1000);
                Recharge();
            }
        }catch (Exception E)
        {
        }
        PaytmGateway();
    }

    public void PaytmGateway() throws InterruptedException {
        Thread.sleep(1000);
        PaytmDebitCardTextField.sendKeys(debitcardnumber);
        Select select=new Select(ExpiryMonthDropdown);
        select.selectByVisibleText(expirymonth);
        Thread.sleep(1000);
        Select select1=new Select(ExpiryYearDropdown);
        select1.selectByVisibleText(expiryyear);
        CVVTextfield.sendKeys(cvv);
        PaytmPayNowButtom.click();
        Thread.sleep(1000);
        /*PaytmOTPTextfield.sendKeys(testOTP);
        OTPSubmitButton.click();*/

        successButton.click();
        Thread.sleep(5000);

    }

    public void PaymentStatusMethod()
    {
        logger.info(PaymentStatus.getText());
        Assert.assertEquals(PaymentStatus.getText(),"Payment Successfull",PaymentStatus.getText());
            logger.info(amount+"----------Amount");
            logger.info(walletamount+"---------Wallet Amount");

            updatedWalletAmount=walletamount+amount;
            logger.info(updatedWalletAmount+"---------Updated Wallet Amount");

            float abc=Float.valueOf(updatedWalletBalance.getText());
            logger.info(abc+"--------->amt");
            if(abc==updatedWalletAmount)
            {
                logger.info("Wallet Balance has been updated");
            }
            //needs to navigate for payment page back to do further payments
            GoToAddCreditPageButton.click();
    }

    /*public void MobikwikGateway() throws InterruptedException {
        Recharge();
        Mobikwik.click();
        PayButton.click();
        Thread.sleep(1000);
        MobikwikCancelButton.click();
    }*/
}