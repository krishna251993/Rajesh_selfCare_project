package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.Constants.PageNavigation;
import com.imclnew.SelfcarePortal.POM.AddAlacartePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAlacarteTest extends BaseTest {
    @Test(enabled = true)
    public void addPlan() throws InterruptedException {
        PageNavigation pagenavigation=new PageNavigation(driver);
        AddAlacartePage addplans=new AddAlacartePage(driver);

        pagenavigation.Navigate_to_AddAlacarte();
        Assert.assertEquals(addplans.VerifyPageTitle(),"Add Ala-Carte","Title not matched");

        addplans.AddPlans();
    }
}