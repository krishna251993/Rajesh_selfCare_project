package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.Constants.PageNavigation;
import com.imclnew.SelfcarePortal.POM.BasePackPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasePlanTestCase extends BaseTest {
    @Test(enabled = true)
    public void AddBasePack() throws InterruptedException {
        PageNavigation pagenavigation = new PageNavigation(driver);
        BasePackPage basepackpage = new BasePackPage(driver);

        pagenavigation.Navigation_to_AddBasePackPage();
        Assert.assertEquals(basepackpage.PageVerification(),"Add Base Plans","Title Not Matching");
            basepackpage.PlanSelection();

    }
}
