package HamBurgerMenuPage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HamBurgerMenuPage {
    String darkMode="com.airtel.xsafe:id/mi_dark_mode";
    String changeLanguage="com.airtel.xsafe:id/tv_item";
    String logOut="com.airtel.xsafe:id/tv_logout";
    public void verifyMenuUI(AndroidDriver driver){
        Assert.assertTrue(driver.findElement(By.id(darkMode)).isDisplayed(),"Darkmode toggle is not visible");
        Assert.assertTrue(driver.findElement(By.id(changeLanguage)).isDisplayed(),"Change language button is not visible");
        Assert.assertTrue(driver.findElement(By.id(logOut)).isDisplayed(),"Logout button is not visible");

    }
}
