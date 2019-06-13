package com.imclnew.SelfcarePortal.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class AddIndigitalPayBouquetPage extends BasePage {
    public AddIndigitalPayBouquetPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@type=\"radio\"]")
    private WebElement Plans;

    @FindBy(xpath = "//*[@id=\"confirm-subscribe\"]")
    private WebElement AddBouquetButton;

    @FindBy(xpath = "//*[@id=\"subscriberplanlist\"]/tbody/tr[1]/td[5]")
    private WebElement PlanPrice;

    @FindBy(xpath = "//*[@id=\"subscription\"]")
    private WebElement SubscriptionAmountInConfirmationPage;

    @FindBy(xpath = "//*[@id=\"tax\"]")
    private WebElement TaxInConfirmationPage;

    @FindBy(xpath = "//*[@id=\"amount\"]")
    private WebElement AmountInConfirmationPage;

    @FindBy(xpath = "//*[@id=\"confirm-modal\"]/div/div/div[2]/div[2]/div/table/tbody/tr/td[1]")
    private WebElement PlanNameInConfirmationPage;

    @FindBy(xpath = "//*[@id=\"amount\"]")
    private WebElement TotalPlanPriceInConfirmationPage;

    @FindBy(xpath = "//*[@id=\"payment-confirm\"]")
    private WebElement PayButtonInConfirmationPage;

    @FindBy(xpath = "//*[@id=\"confirm-modal\"]/div/div/div[2]/div[1]/p[1]/div/strong")
    private WebElement ErrorMgs;

    @FindBy(xpath = "//*[@id=\"confirm-modal\"]/div/div/div[1]/button/span[1]")
    private WebElement CloseButton;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/h3")
    private WebElement AddIndigitalheader;

    @FindBy(xpath = "//*[@id=\"subscriberplanlist\"]")
    private WebElement PlansTable;

    public String VerifyPageTitle()
    {
        waitTillTheElementVisible(AddIndigitalheader);
        waitTillTheElementVisible(PlansTable);
        logger.info("verifying Page header");
        String header = AddIndigitalheader.getText();
        logger.info(header+" is the header");
        return header;
    }

    public void ListOfPlan() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> list =driver.findElements(By.xpath("//*[@type=\"radio\"]"));

        logger.info("Total number of plans------"+list.size());
        Random rand=new Random();
        Thread.sleep(1000);

        int SelectedPlan=rand.nextInt(list.size());
        if(SelectedPlan<=0)
        {
            SelectedPlan++;
        }
        logger.info(SelectedPlan);
        driver.findElement(By.xpath("(//*[@type=\"radio\"])"+"["+SelectedPlan+"]")).click();

        String NCFPrice=driver.findElement(By.xpath("//*[@id=\"subscriberplanlist\"]/tbody/"+"tr["+SelectedPlan+"]/"+"td[5]")).getText();
        String PlanPrice=driver.findElement(By.xpath("//*[@id=\"subscriberplanlist\"]/tbody/"+"tr["+SelectedPlan+"]/"+"td[4]")).getText();
        String PlanName=driver.findElement(By.xpath("//*[@id=\"subscriberplanlist\"]/tbody/"+"tr["+SelectedPlan+"]/"+"td[2]")).getText();

        AddBouquetButton.click();

        float Sum = Float.parseFloat(NCFPrice )+ Float.parseFloat(PlanPrice);
        float Tax = (Sum * 18) / 100;
        float TotalPrice = Sum + Tax;

        logger.info("Sum---->"+Sum);
        logger.info("Tax---->"+Tax);
        logger.info("Total Price---->"+TotalPrice);

        Thread.sleep(10000);
        logger.info("PlanName-->"+PlanNameInConfirmationPage.getText());
        logger.info("SubscriptionAmount------------>"+SubscriptionAmountInConfirmationPage.getText());
        logger.info("TaxInConfirmation------>"+TaxInConfirmationPage.getText());

        waitTillTheElementVisible(CloseButton);
        if (PlanNameInConfirmationPage.getText().equalsIgnoreCase(PlanName)) {
            Thread.sleep(1000);
            if (SubscriptionAmountInConfirmationPage.getText().equalsIgnoreCase(String.valueOf(Sum))) {
                Thread.sleep(1000);
                if (TaxInConfirmationPage.getText().equalsIgnoreCase(Float.toString(Tax)) && TotalPlanPriceInConfirmationPage.getText().equalsIgnoreCase(String.valueOf(TotalPrice)));
                {
                    Thread.sleep(1000);
                    PayButtonInConfirmationPage.click();
                    try {
                        Thread.sleep(2000);
                        if (ErrorMgs.isDisplayed())
                        {
                            logger.info(ErrorMgs.getText());
                        }
                    }catch (Exception E)
                    {

                    }
                    CloseButton.click();
                }
            }
        }
    }
}