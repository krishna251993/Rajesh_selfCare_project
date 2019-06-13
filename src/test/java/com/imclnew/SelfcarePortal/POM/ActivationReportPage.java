package com.imclnew.SelfcarePortal.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ActivationReportPage extends BasePage {
    public ActivationReportPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div[4]/div[1]/div/h3")
    private WebElement activationReportHeader;
    @FindBy(xpath = "//*[@id=\"activationstatus\"]")
    private WebElement activationstatusDropdown;
    @FindBy(xpath = "/html/body/div[4]/div[3]/div/table/tbody/tr/td")
    private WebElement Error;

    public String VerifyPageTitle() throws InterruptedException {
        Thread.sleep(1000);
        logger.info("verifying Page header");
        String header = activationReportHeader.getText();
        logger.info(header+" is the header");
        return header;
    }

    public void ActivationStatus()
    {
        Select ele=new Select(activationstatusDropdown);
        ele.selectByVisibleText("ALL");

        if(Error.isEnabled())
        {
            System.out.println(Error.getText());
        }
    }
}
