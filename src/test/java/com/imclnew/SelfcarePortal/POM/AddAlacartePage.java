package com.imclnew.SelfcarePortal.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class AddAlacartePage extends BasePage {
    public AddAlacartePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[1]/h3")
    private WebElement AddAlacarteheader;
    @FindBy(xpath = "//*[@id=\"confirm-subscribe\"]")
    private WebElement AddAddonButton;
    @FindBy(xpath = "//*[@id=\"confirmcart\"]")
    private WebElement SubscriberButton;
    @FindBy(xpath = "/html/body/div[5]/div[4]/div[4]/div/table/tbody/tr/td")
    private WebElement Error;

    public String VerifyPageTitle()
    {
        logger.info("verifying Page header");
        String header = AddAlacarteheader.getText();
        logger.info(header+" is the header");
        return header;
    }

    public void AddPlans() throws InterruptedException {
        Thread.sleep(10000);
        List<WebElement> list =driver.findElements(By.xpath("//*[@id=\"subscriberplanlist\"]/tbody/tr"));

        logger.info("Total number of plans------"+list.size());
        Random rand=new Random();
        Thread.sleep(5000);
        int FirstSelectedPlan=rand.nextInt(list.size());
        if(FirstSelectedPlan<=0)
        {
            FirstSelectedPlan++;
        }
        logger.info(FirstSelectedPlan);
        int SecondselectedPlan=rand.nextInt(list.size());
        if(SecondselectedPlan<=0)
        {
            SecondselectedPlan++;
            if(FirstSelectedPlan==SecondselectedPlan)
            {
                SecondselectedPlan++;
            }
        }
        logger.info(SecondselectedPlan);
        driver.findElement(By.xpath("//*[@id=\"subscriberplanlist\"]/tbody/tr["+FirstSelectedPlan+"]/td[6]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"subscriberplanlist\"]/tbody/tr["+SecondselectedPlan+"]/td[6]/input")).click();

        AddAddonButton.click();
        waitTillTheElementVisible(SubscriberButton);
        SubscriberButton.click();

        Thread.sleep(5000);

        if (Error.isDisplayed())
        {
            System.out.println(Error.getText());
        }
    }
}