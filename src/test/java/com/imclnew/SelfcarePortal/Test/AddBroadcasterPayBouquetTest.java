package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.Constants.PageNavigation;
import com.imclnew.SelfcarePortal.POM.AddBroadcasterPayBouquetPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddBroadcasterPayBouquetTest extends BaseTest {
    @Test(enabled = true)
    public void AddBroadcasterPayBouquet() throws InterruptedException {
        PageNavigation pagenavigation=new PageNavigation(driver);
        AddBroadcasterPayBouquetPage AddBroadcasterPayBouquet=new AddBroadcasterPayBouquetPage(driver);

        pagenavigation.Navigate_to_AddBroadcasterPayBouquet();
        Assert.assertEquals(AddBroadcasterPayBouquet.VerifyPageTitle(),"Add Indigital Addons/Broadcaster Pay Bouquet","Title not matched");

            AddBroadcasterPayBouquet.AddPlans();
    }
}