package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.Constants.PageNavigation;
import com.imclnew.SelfcarePortal.POM.AddIndigitalPayBouquetPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddIndigitalPayBouquetTest extends BaseTest {
    @Test(enabled = true)
    public void Add_Indigital_Pay_Bouquet() throws InterruptedException {
        PageNavigation navigation=new PageNavigation(driver);
        AddIndigitalPayBouquetPage addindigitalpaybouquet=new AddIndigitalPayBouquetPage(driver);

        navigation.Navigate_to_AddIndigitalPayBouquet();

        Assert.assertEquals(addindigitalpaybouquet.VerifyPageTitle(),"Add Indigital Pay Bouquet","Header Mismatch");
           addindigitalpaybouquet.ListOfPlan();
    }
}
