package com.imclnew.SelfcarePortal.Constants;

import com.imclnew.SelfcarePortal.POM.BasePage;
import com.imclnew.SelfcarePortal.Test.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageNavigation extends BaseTest {
    BasePage basePage=new BasePage(driver);

    @FindBy(xpath="/html/body/div[2]/div[2]/div/a[2]")
    private WebElement RegisterLink;

    @FindBy(xpath = "//*[@id=\"forgotpassword\"]")
    private WebElement ForgotPasswordLink;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")
    private WebElement PlanHeader;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/ul/li[1]/a")
    private WebElement BasePackHeader;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")
    private WebElement PaymentHeader;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/ul/li[1]/a")
    private WebElement Payment_SubHeader_RechargeMyAccount;

    @FindBy(xpath = "/html/body/nav[1]/div/div[1]/h2")
    private WebElement CustomerSelfcarePortalHeader;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/ul/li[2]/a")
    private WebElement Payment_SubHeader_PaymentReport;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div/h3")
    private WebElement PaymentReportPageHeader;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/ul/li[2]/a")
    private WebElement AddIndigitalPayBouquet;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/ul/li[3]/a")
    private WebElement AddBroadcasterPayBouquet;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/ul/li[4]/a")
    private WebElement AddAlacarte;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[4]/a")
    private WebElement ReportsHeader;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[4]/ul/li/a")
    private WebElement ActivationReportHeader;

    @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[5]/a")
    private WebElement ProfileHeader;

    public PageNavigation(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void Navigate_to_RegisterPage() throws InterruptedException {
        Thread.sleep(1000);
        RegisterLink.click();
    }
    public void Navigation_to_forgotpasswordPage()
    {
        ForgotPasswordLink.click();
    }
    public void Navigation_to_AddBasePackPage() {
        //BasePage basePage=new BasePage(driver);
        basePage.waitTillTheElementVisible(CustomerSelfcarePortalHeader);
        PlanHeader.click();
        BasePackHeader.click();
    }
    public void Navigate_to_RechargeMyAccountPage() throws InterruptedException {
        Thread.sleep(1000);
        basePage.waitTillTheElementVisible(CustomerSelfcarePortalHeader);
        PaymentHeader.click();
        Payment_SubHeader_RechargeMyAccount.click();
    }
    public void Navigate_to_PaymentReport() throws InterruptedException {
        Thread.sleep(1000);
        PaymentHeader.click();
        Thread.sleep(1000);
        Payment_SubHeader_PaymentReport.click();
        basePage.waitTillTheElementVisible(PaymentReportPageHeader);
    }
    public void Navigate_to_AddIndigitalPayBouquet() throws InterruptedException {
        basePage.waitTillTheElementVisible(PlanHeader);
        Thread.sleep(1000);
        PlanHeader.click();
        Thread.sleep(2000);
        AddIndigitalPayBouquet.click();
    }
    public void Navigate_to_AddBroadcasterPayBouquet() throws InterruptedException {
        basePage.waitTillTheElementVisible(PlanHeader);
        Thread.sleep(1000);
        PlanHeader.click();
        Thread.sleep(1000);
        AddBroadcasterPayBouquet.click();
    }
    public void Navigate_to_AddAlacarte() throws InterruptedException {
        basePage.waitTillTheElementVisible(PlanHeader);
        PlanHeader.click();
        Thread.sleep(1000);
        AddAlacarte.click();
    }
    public void Navigate_to_ActivationReports() throws InterruptedException {
        basePage.waitTillTheElementVisible(ReportsHeader);
        Thread.sleep(1000);
        ReportsHeader.click();
        Thread.sleep(1000);
        ActivationReportHeader.click();
    }
    public void Navigate_to_ProfileHeader()
    {
        basePage.waitTillTheElementVisible(ReportsHeader);
        ProfileHeader.click();
    }
}