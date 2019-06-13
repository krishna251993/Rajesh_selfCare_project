package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.Constants.PageNavigation;
import com.imclnew.SelfcarePortal.POM.PaymentReportPage;
import com.imclnew.SelfcarePortal.Utilities.TypeOfCustomer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PaymentReportTestCase extends BaseTest {
    @Test(enabled = true)
    public void PaymentReport() throws InterruptedException, IOException {
        PageNavigation pagenavigation = new PageNavigation(driver);
        PaymentReportPage paymentreportpage = new PaymentReportPage(driver);

        TypeOfCustomer customer=new TypeOfCustomer(driver);

        if(! customer.customerType().equalsIgnoreCase("LCO Customer"))
        {
            pagenavigation.Navigate_to_PaymentReport();

            Assert.assertEquals(paymentreportpage.PageVerification(), "Payments", "Title Not Matching");

            paymentreportpage.SelectPaymentStatus();
            //paymentreportpage.ListOfPayment();
        }
    }
}