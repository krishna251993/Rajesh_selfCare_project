package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.POM.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test(enabled = true)

    public void Logout_from_portal()
    {
        LogoutPage logout=new LogoutPage(driver);

        logout.LogoutFromPortal();
        //Assert.assertEquals(driver.getCurrentUrl(),url,"URL Mismatch");
    }
}