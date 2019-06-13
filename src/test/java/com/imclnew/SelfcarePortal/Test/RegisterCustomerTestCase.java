package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.Constants.PageNavigation;
import com.imclnew.SelfcarePortal.POM.LoginPage;
import com.imclnew.SelfcarePortal.POM.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterCustomerTestCase extends BaseTest{
    @Test(enabled = false)
    public void Register_Customer_For_Selfcare_Portal() throws InterruptedException, IOException {
        SignupPage signupPage = new SignupPage(driver);
        PageNavigation pageNavigation = new PageNavigation(driver);

        pageNavigation.Navigate_to_RegisterPage();
        signupPage.Register_To_Selfcare_Portal();
        signupPage.SignUp();
        signupPage.OTP();

        LoginPage loginpage = new LoginPage(driver);

        Assert.assertEquals(loginpage.verifyPageTitle(), "LOGIN","Title not matched");

        loginpage.setAuthenticateUsingSelect();
        loginpage.setUsername();

        loginpage.setPassword();
        loginpage.clickLoginButton();
        //loginpage.errorMsg();
    }
}