package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.Constants.PageNavigation;
import com.imclnew.SelfcarePortal.POM.PaymentPage;
import com.imclnew.SelfcarePortal.Utilities.TypeOfCustomer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RechargeMyAccountTestCase extends BaseTest {
    @Test(enabled = true)
    public void Rechargewallet() throws InterruptedException {
        PaymentPage paymentpage=new PaymentPage(driver);
        PageNavigation pagenavigation = new PageNavigation(driver);
        TypeOfCustomer customer=new TypeOfCustomer(driver);

        if(! customer.customerType().equalsIgnoreCase("LCO Customer")) {
            pagenavigation.Navigate_to_RechargeMyAccountPage();
            Assert.assertEquals(paymentpage.PageVerification(), "Recharge my account", "Title Not Matching");

            paymentpage.Recharge();
            logger.info("Recharge 1st");
            Thread.sleep(1000);
            paymentpage.PaymentGateway();
            logger.info("TPSL GATEWAY ENDS");
            Thread.sleep(1000);
            paymentpage.PaymentStatusMethod();
            logger.info("payment status methods ends");
            //driver.navigate().back();
            //paymentpage.MobikwikGateway();
        }
        else logger.info("LCO Customer doesnt have any wallet");
    }
}