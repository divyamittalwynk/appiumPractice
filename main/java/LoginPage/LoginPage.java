package LoginPage;

import commonMethods.commonMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LoginPage {

    commonMethods commonMethods=new commonMethods();
    String RTNInput="com.airtel.xsafe:id/tie";
    String continueCTA="com.airtel.xsafe:id/btn_continue";
    String loginText="com.airtel.xsafe:id/sub_title";
    String terms="com.airtel.xsafe:id/tv_terms";
    String OTP="123456";
    String nextCTA="com.airtel.xsafe:id/btn_submit";
    String displayInput= "//android.widget.EditText[@text='Display Name']";
    String allowNotification="com.android.permissioncontroller:id/permission_allow_button";
    String closeCoachMark="com.airtel.xsafe:id/iv_cancel";

    public void verifyLoginPage(AndroidDriver driver)
    {
        Assert.assertTrue(driver.findElement(By.id(terms)).isDisplayed(),"Terms and conditions are not visible.");
        Assert.assertTrue(driver.findElement(By.id(loginText)).isDisplayed(),"Login description is not visible.");
        Assert.assertTrue(driver.findElement(By.id(RTNInput)).isDisplayed(),"Login number input field is not visible.");
        Assert.assertTrue(driver.findElement(By.id(continueCTA)).isDisplayed(),"Continue button is not working on loginpage.");

    }
    public void clickOnlogin(String RTN,AndroidDriver driver,WebDriverWait wait) throws IOException, InterruptedException {
        commonMethods.MobileElementClick(RTNInput,driver);
        commonMethods.sendKeys(RTN,RTNInput,driver);
        commonMethods.MobileElementClick(continueCTA,driver);
        commonMethods.waitForElement(RTNInput,wait);
        commonMethods.MobileElementClick(RTNInput,driver); // OTP locator is same as RTN locator.
        commonMethods.sendKeys(OTP,RTNInput,driver);
        commonMethods.MobileElementClick(continueCTA,driver);

    }
    public void clickNextButtons(AndroidDriver driver,WebDriverWait wait) throws InterruptedException {
        commonMethods.waitForElement(nextCTA, wait);
        for(int i=0;i<3;i++) {
            commonMethods.MobileElementClick(nextCTA, driver);
        }
    }

    public void setDisplayName(String displayName, AndroidDriver driver,WebDriverWait wait){
        commonMethods.waitForElement(displayName,wait);
        commonMethods.MobileElementClick(displayInput, driver);
        commonMethods.sendKeys(displayName,displayInput,driver);
        commonMethods.MobileElementClick(continueCTA,driver);
    }
    public void clickOnNotification(AndroidDriver driver,WebDriverWait wait) throws InterruptedException {
        for(int i=0;i<2;i++) {
            commonMethods.waitForElement(allowNotification, wait);
            commonMethods.MobileElementClick(allowNotification, driver);
        }
    }
    public void closeCoachMark(AndroidDriver driver,WebDriverWait wait) throws InterruptedException {
        for(int i=0;i<2;i++) {
            commonMethods.waitForElement(closeCoachMark, wait);
            commonMethods.MobileElementClick(closeCoachMark, driver);
        }
    }

}
