import HamBurgerMenuPage.HamBurgerMenuPage;
import HomePage.HomePage;
import LoginPage.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import commonMethods.commonMethods;

public class Smoke {
    AppiumDriverLocalService service;
    AndroidDriver driver;
    WebDriverWait wait;
    commonMethods commonMethods;
    LoginPage loginPage;
    HomePage homePage;
    HamBurgerMenuPage hamBurgerMenuPage;
    String closePhoneNumber="com.google.android.gms:id/cancel";
    String RTN ="9666488108";
    String displayName="Testing";
    String skipForNow="//android.widget.TextView[@text='Skip for Now']";
    String hamBurgerMenu="com.airtel.xsafe:id/iv_menu";
    String XsafeAppPackage="com.airtel.xsafe";
    String XsafeAppActivity="com.airtel.xsafesdk.ui.activity.HomeActivity";


    @BeforeClass
    public void prerequistic() throws URISyntaxException, MalformedURLException {
        commonMethods=new commonMethods(); // util pkg in java --> base class
        loginPage=new LoginPage();
        homePage=new HomePage();
        hamBurgerMenuPage= new HamBurgerMenuPage();
        service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("divya"); //virtual mobile name of android studio
       options.setApp(System.getProperty("user.dir")+"/src/test/java/resources/app-dev-debug.apk"); //commenting this line as while pushing code, its failing due to apk size.
        driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test(priority = 0, description = "Login into the Xsafe app and verify the login page UI ")
    public void verifyLogin() throws InterruptedException, IOException {
        loginPage.clickNextButtons(driver,wait);
        commonMethods.waitForElement(closePhoneNumber,wait);
        commonMethods.MobileElementClick(closePhoneNumber, driver);
        Thread.sleep(1000);
        loginPage.verifyLoginPage(driver);
        loginPage.clickOnlogin(RTN,driver,wait);
        loginPage.setDisplayName(displayName,driver,wait);
        commonMethods.waitForElement(skipForNow,wait);
        commonMethods.MobileElementClick(skipForNow, driver);
        loginPage.clickOnNotification(driver,wait);
        loginPage.closeCoachMark(driver,wait);

    }
    @Test(priority =1,description = "Verify the homepage UI.")
    public void verifyHome() throws InterruptedException {
        commonMethods.startActivity(driver,XsafeAppPackage,XsafeAppActivity);
        homePage.verifyHomeUI(driver);
    }
    @Test(priority =2,description = "Verify the Ui of Hamburger Menu")
    public void verifyMenu() throws InterruptedException {
        commonMethods.waitForElement(hamBurgerMenu,wait);
        commonMethods.MobileElementClick(hamBurgerMenu,driver);
        hamBurgerMenuPage.verifyMenuUI(driver);
        commonMethods.startActivity(driver,XsafeAppPackage,XsafeAppActivity);

    }
    @AfterClass
    public void close()
    {
        driver.quit();
        service.stop();
    }
}
