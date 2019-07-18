package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.POM.LoginPage;
import com.imclnew.SelfcarePortal.Utilities.CustomerIDType;
import com.imclnew.SelfcarePortal.Utilities.TypeOfCustomer;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCase extends BaseTest {
    @Test(enabled = true)
    public void login_to_selfcare_portal() throws IOException, InterruptedException {
        LoginPage loginpage = new LoginPage(driver);


            Assert.assertEquals(loginpage.verifyPageTitle(), "LOGIN","Title not matched");

                  loginpage.setAuthenticateUsingSelect();
                 loginpage.setUsername();
                 loginpage.setPassword();
                 loginpage.clickLoginButton();

                 Thread.sleep(2000);
                 loginpage.verifyPage();
                 //loginpage.errorMsg();

    }
}