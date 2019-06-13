package com.imclnew.SelfcarePortal.Utilities;

import com.imclnew.SelfcarePortal.Test.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot extends BaseTest {

    public String getScreenshot(String Screenshot) throws IOException {
        TakesScreenshot ts= (TakesScreenshot) driver;
        //object of take screenshot, we cant take object of an interface so typecast the webdriver instance.

        File source = ts.getScreenshotAs(OutputType.FILE);
        //which will capture the screenshot

/*
        String destination = System.getProperty("D:\\IdeaProjects\\ImclSelfcarePortalNewAutomation") + "\\Screenshots\\" + Screenshot + timestamp() + ".png";
*/

        String destination = System.getProperty("user.dir") + "\\Screenshots\\" + Screenshot + timestamp() + ".png";

        File finaldestination = new File(destination);

        FileUtils.copyFile(source, finaldestination);

        return destination;
    }

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

}
