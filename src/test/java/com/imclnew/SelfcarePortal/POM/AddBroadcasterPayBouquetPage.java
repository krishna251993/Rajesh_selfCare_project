package com.imclnew.SelfcarePortal.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;


public class AddBroadcasterPayBouquetPage extends BasePage {

    public AddBroadcasterPayBouquetPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[1]/h3")
    private WebElement AddBroadcasterheader;
    @FindBy(xpath = "//*[@id=\"subscriberplanlist\"]/tbody/tr[1]")
    private WebElement Plans;
    @FindBy(xpath = "//*[@id=\"confirm-subscribe\"]")
    private WebElement AddPlanButton;

    @FindBy(xpath = "//*[@id=\"subscriberplanlist\"]/tbody/tr[1]/td[6]/input")
    private WebElement CheckBox;
    @FindBy(xpath = "//*[@id=\"confirm-subscribe\"]")
    private WebElement AddAddon_BroadcasterButton;
    @FindBy(xpath = "//*[@id=\"confirmcart\"]")
    private WebElement SubscribeButton;
    @FindBy(xpath = "/html/body/div[5]/div[4]/div[4]/div/table/tbody/tr/td")
    private WebElement Error;
    @FindBy(xpath = "/html/body/div[4]/div[4]/div[4]/div/table/tbody/tr")
    private WebElement message;

    public String VerifyPageTitle()
    {
        logger.info("verifying Page header");
        String header = AddBroadcasterheader.getText();
        logger.info(header+" is the header");
        return header;
    }

    public void AddPlans() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> list =driver.findElements(By.xpath("//*[@id='subscriberplanlist']/tbody/tr"));

        logger.info("Total number of plans------"+list.size());
        Random rand=new Random();
        Thread.sleep(1000);
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

        AddAddon_BroadcasterButton.click();
        waitTillTheElementVisible(SubscribeButton);
        SubscribeButton.click();

        Thread.sleep(1000);
        try {
            if (Error.isDisplayed()) {
                System.out.println(Error.getText());
            }
        }catch (Exception E)
        {
            if(driver.findElement(By.xpath("/html/body/div[4]/div[4]/div[4]/div/table/tbody/tr")).isDisplayed())
            {
                int n=1;
                for (int i=0;i<=n;i++)
                {
                    System.out.println(driver.findElement(By.xpath("/html/body/div[4]/div[4]/div[4]/div/table/tbody/tr["+i+"]")).getText());
                }
            }
        }
    }
}