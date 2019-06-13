package com.imclnew.SelfcarePortal.POM;

import com.imclnew.SelfcarePortal.Utilities.WriteDataToExcelSheet;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static com.imclnew.SelfcarePortal.Test.BaseTest.*;

public class PaymentReportPage extends BasePage {
    @FindBy(xpath = "/html/body/div[4]/div[1]/div/h3")
    private WebElement PaymentHeader;

    @FindBy(xpath = "//*[@id=\"status\"]")
    private WebElement PaymentStatusDropDown;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/table")
    private WebElement PaymentListTable;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/table/thead/tr/th[1]")
    private WebElement PaymentListHeader;

    @FindBy(xpath = "/html/body/div[4]/div[3]/div/table/tbody/tr[1]")
    private WebElement PaymentListBody;

    public PaymentReportPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String PageVerification()
    {
        String Header = PaymentHeader.getText();
        return Header;
    }

    public void SelectPaymentStatus()
    {
        //log.info("Selecting Payment Status");
        Select select = new Select(PaymentStatusDropDown);
        List<WebElement> list = select.getOptions();
        logger.info("Payment Status--->"+"\n");
        for (int i=0;i<list.size();i++)
        {
            logger.info(list.get(i).getText()+"\n");
        }
        Random rand=new Random();
        int selection = rand.nextInt(list.size());
        select.selectByIndex(selection);
        select.selectByVisibleText("ALL");
    }

    /*public void ListOfPayment() throws InterruptedException, IOException {
        Thread.sleep(5000);
        WebElement headerCount=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/table/thead/tr"));

        List<WebElement> ListOfPayments=headerCount.findElements(By.tagName("th"));

        logger.info("list size---->"+ListOfPayments.size());
        for(int i =0;i<ListOfPayments.size();i++)
        {
            logger.info(ListOfPayments.get(i).getText());
        }

        WebElement count=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/table/tbody"));

        WebElement paymentsCount=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/table/tbody/tr"));

        List<WebElement> payments=count.findElements(By.tagName("tr"));

        logger.info(ListOfPayments.size());
        logger.info(payments.size());

        for (int j=1;j<=payments.size();j++)
        {
            for (int k=1;k<=ListOfPayments.size();k++)
            {
                WebElement text=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/table/tbody/tr["+j+"]/td["+k+"]"));
                String data=text.getText();
                logger.info(data);
                WriteDataToExcelSheet write = new WriteDataToExcelSheet();
                String pageName="PaymentsList";
                write.writeExcel(ExcelFilePath,ExcelFileName,pageName,k,data);
            }
        }
    }*/
}