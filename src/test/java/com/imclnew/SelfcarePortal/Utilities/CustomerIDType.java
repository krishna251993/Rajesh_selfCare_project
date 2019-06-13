package com.imclnew.SelfcarePortal.Utilities;

import org.openqa.selenium.WebElement;

import static com.imclnew.SelfcarePortal.POM.LoginPage.*;

public class CustomerIDType {
    public static String getUserLoginType(String un) {
       String element = null;
       if (un.length() == 8) {
            element = "Customer Account Number";
        } else if (un.length() == 12) {
            element = "Smart Card Number";
        } else if (un.length() == 18) {
            element = "STB Number";
        }
        return element;
    }
}