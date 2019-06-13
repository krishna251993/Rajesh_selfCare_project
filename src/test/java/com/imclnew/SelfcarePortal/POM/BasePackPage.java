package com.imclnew.SelfcarePortal.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class BasePackPage extends BasePage {
    public BasePackPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/h3")
    private WebElement BasePackHeader;

    @FindBy(xpath = "//*[@id=\"confirm-subscribe\"]")
    private WebElement SubscribeButton;

    @FindBy(xpath = "//*[@type=\"radio\"]")
    private WebElement Plans;

    @FindBy(xpath = "//*[@id=\"confirm-modal\"]/div/div/div[2]/div[2]/div/table/tbody/tr/td[1]")
    private WebElement PlanNameInConfirmationPage;

    @FindBy(xpath = "//*[@id=\"subscription\"]")
    private WebElement SubscriptionAmountInConfirmationPage;

    @FindBy(xpath = "//*[@id=\"tax\"]")
    private WebElement TaxInConfirmationPage;

    @FindBy(xpath = "//*[@id=\"payment-confirm\"]")
    private WebElement PayButtonInConfirmationPage;

    @FindBy(xpath = "//*[@id=\"confirm-modal\"]/div/div/div[2]/div[1]/p[2]/div/strong")
    private WebElement ErrorMgs;

    @FindBy(xpath = "//*[@id=\"confirm-modal\"]/div/div/div[1]/button/span[1]")
    private WebElement CloseButton;

    @FindBy(xpath = "//*[@id=\"amount\"]")
    private WebElement TotalPlanPriceInConfirmationPage;

    public String PageVerification()
    {
        String title=BasePackHeader.getText();
        return title;
    }

    public void PlanSelection() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> list =driver.findElements(By.xpath("//*[@type=\"radio\"]"));

        logger.info("Total number of plans------"+list.size());
        Random rand=new Random();
        Thread.sleep(5000);
        int SelectedPlan=rand.nextInt(list.size());
        if(SelectedPlan<=0)
        {
            SelectedPlan++;
        }
        logger.info(SelectedPlan);
        driver.findElement(By.xpath("(//*[@type=\"radio\"])"+"["+SelectedPlan+"]")).click();

        String PlanName=driver.findElement(By.xpath("//*[@id=\"subscriberplanlist\"]/tbody/tr["+ SelectedPlan + "]/td[2]")).getText();
        String PlanPrice=driver.findElement(By.xpath("//*[@id=\"subscriberplanlist\"]/tbody/tr["+ SelectedPlan + "]/td[4]")).getText();
        String NCFPrice=driver.findElement(By.xpath("//*[@id=\"subscriberplanlist\"]/tbody/tr["+ SelectedPlan + "]/td[5]")).getText();

        SubscribeButton.click();

        float Sum = Float.parseFloat(NCFPrice )+ Float.parseFloat(PlanPrice);

        System.out.println("Sum -"+Sum);
        float Tax = (Sum * 18) / 100;
        float TotalPrice = Sum + Tax;

        logger.info("Sum---->"+Sum);
        logger.info("Tax---->"+Tax);
        logger.info("Total Price---->"+TotalPrice);

        Thread.sleep(5000);
        logger.info("PlanName-->"+PlanNameInConfirmationPage.getText());
        logger.info("SubscriptionAmount------------>"+SubscriptionAmountInConfirmationPage.getText());
        logger.info("TaxInConfirmation------>"+TaxInConfirmationPage.getText());

        if (PlanNameInConfirmationPage.getText().equalsIgnoreCase(PlanName)) {
            logger.info(PlanNameInConfirmationPage.getText());
            Thread.sleep(1000);

            float amt=Float.parseFloat(SubscriptionAmountInConfirmationPage.getText());
            System.out.println("Amount="+amt);

            if (Sum==amt) {
                Thread.sleep(1000);

                float confirmationTax=Float.parseFloat(TaxInConfirmationPage.getText());
                float confirmationPlanPrice=Float.parseFloat(TotalPlanPriceInConfirmationPage.getText());

                waitTillTheElementVisible(PayButtonInConfirmationPage);

                System.out.println("confirmationTax--->"+confirmationTax);
                System.out.println("TAX--->"+Tax);
                System.out.println("confirmationPlanPrice--->"+confirmationPlanPrice);
                System.out.println("TotalPrice--->"+TotalPrice);

                Thread.sleep(1000);

                if ((confirmationTax==Tax)&&(confirmationPlanPrice==TotalPrice))
                {
                    System.out.println("Inside the loop");
                    logger.info(PayButtonInConfirmationPage.getText());
                    Thread.sleep(3000);
                    PayButtonInConfirmationPage.click();
                    try {
                        Thread.sleep(2000);
                        if (ErrorMgs.isDisplayed()|| ErrorMgs.isEnabled())
                        {
                            logger.info(ErrorMgs.getText());
                        }
                        Thread.sleep(1000);
                    }catch (Exception E)
                    {
                    }
                    Thread.sleep(2000);
                    CloseButton.click();
                }
            }
            System.out.println("Akshatha");
        }
    }
}