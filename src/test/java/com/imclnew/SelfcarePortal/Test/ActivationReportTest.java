package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.Constants.PageNavigation;
import com.imclnew.SelfcarePortal.POM.ActivationReportPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivationReportTest extends BaseTest {
    @Test(enabled = true)
    public void activationreport() throws InterruptedException {
        PageNavigation pagenavigation=new PageNavigation(driver);
        ActivationReportPage report=new ActivationReportPage(driver);

        pagenavigation.Navigate_to_ActivationReports();
        Assert.assertEquals(report.VerifyPageTitle(),"Activation Report","Title not matched");

            report.ActivationStatus();
    }
}