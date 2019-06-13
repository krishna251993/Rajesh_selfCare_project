package com.imclnew.SelfcarePortal.Test;

import com.imclnew.SelfcarePortal.Constants.IAutomationConstants;
import com.imclnew.SelfcarePortal.Utilities.GetDataFromExcelSheet;
import com.imclnew.SelfcarePortal.Utilities.Property;
import com.imclnew.SelfcarePortal.Utilities.Screenshot;
import com.relevantcodes.extentreports.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Listeners(com.imclnew.SelfcarePortal.Utilities.Listeners.class)
public class BaseTest implements IAutomationConstants {

    public static WebDriver driver;

    public Logger logger;

    public static String url;
    public static String un;
    public static String pw;
    public static long timeout;
    public static String MobNo;
    public static String Email_id;
    public static String debitcardnumber;
    public static String cvv;
    public static String testOTP;
    public static String expirymonth;
    public static String expiryyear;

    public static ExtentReports report;
    public static ExtentTest test;

    //Excel file related//
    public static String ExcelFileName="IMCL_Selfcare_DataSheet.xlsx";
    public static String ExcelFilePath=System.getProperty("user.dir")+"\\ExcelData\\";
    public static String ExcelPageName="LoginData";
    public static int row=0;
    public static int col=0;

    public BaseTest()
    {
        logger=Logger.getLogger("Log file");
        PropertyConfigurator.configure("log4j.properties");
    }

    public void initFrameWork() throws IOException {
        url = Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "URL");
        un=GetDataFromExcelSheet.readExcel(ExcelFilePath,ExcelFileName,ExcelPageName,0,0);
        pw=GetDataFromExcelSheet.readExcel(ExcelFilePath,ExcelFileName,ExcelPageName,0,1);
        timeout = Long.parseLong(Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "IMPLICIT"));
        MobNo=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE , "MobileNo");
        Email_id=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"EmailId");
        debitcardnumber=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"DebitCardNumber");
        cvv=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"CVV");
        testOTP=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"OTP");
        expirymonth=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"ExpiryMonth");
        expiryyear=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"ExpiryYear");
    }

    @Parameters({"browser"})
    @BeforeSuite
    public void initApplication(@Optional("chrome") String browser) throws IOException, InterruptedException {
        logger.info("Initializing Framework\n\n");
        try {
            if (browser.equals("chrome")) {
                System.setProperty(CHROME_KEY, CROME_DRIVER_PATH + CHROME_FILE);
                String downloadFilepath = "E:..Report..SelfCareReport";
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 2);
                chromePrefs.put("download.default_directory", downloadFilepath);
                ChromeOptions options = new ChromeOptions();

                HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
                options.setExperimentalOption("prefs", chromePrefs);
                options.addArguments("--test-type");
                options.addArguments("--disable-extensions");

                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
                cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                cap.setCapability(ChromeOptions.CAPABILITY, options);

                ChromeDriverService service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(CROME_DRIVER_PATH)).usingAnyFreePort().build();
                driver = new ChromeDriver(service, options);
            }
            initFrameWork();
            driver.manage().window().maximize();
            driver.get(url);
        } catch (NumberFormatException e) {
        }
    }

    @AfterSuite(alwaysRun = true)
    public void CloseFramework()
    {
        logger.info("Closing Framework");
        //driver.close();
    }

    @AfterMethod
    public void TakeScreenshot(ITestResult result) throws IOException
    {
        if (ITestResult.FAILURE==result.getStatus())
        {
            Screenshot screen= new Screenshot();
            String path=screen.getScreenshot(result.getName());
            test.log(LogStatus.FAIL,test.addScreenCapture(path));
        }
    }

    @BeforeTest
    public void extent() {
        report = new ExtentReports(System.getProperty("user.dir")+"ExtendReports.html",true,DisplayOrder.OLDEST_FIRST, NetworkMode.OFFLINE);
    }

    @AfterTest
    public void test() {
        report.flush();
        //report.close();
    }
}