package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.Constants.PageNavigation;
import com.imclnew.SelfcarePortal.POM.ProfilePage;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {
    @Test(enabled = true)
    public void updateProfile()
    {
        PageNavigation pagenavigation=new PageNavigation(driver);
        ProfilePage page=new ProfilePage(driver);

        pagenavigation.Navigate_to_ProfileHeader();

    }
}
