package HomePage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage {
    String hamBurgerMenu="com.airtel.xsafe:id/iv_menu";
    String homeTitle="com.airtel.xsafe:id/title";
    String addDevice="com.airtel.xsafe:id/iv_add_device";
    String cameraTitle="com.airtel.xsafe:id/toolbar_title";
    String playIcon="com.airtel.xsafe:id/play_pause";
    public void verifyHomeUI(AndroidDriver driver){
        Assert.assertTrue(driver.findElement(By.id(hamBurgerMenu)).isDisplayed(),"Hamburger menu is not visible");
        Assert.assertTrue(driver.findElement(By.id(homeTitle)).isDisplayed(),"Xsafe title is not visible");
        Assert.assertTrue(driver.findElement(By.id(addDevice)).isDisplayed(),"Camera adding plus icon is not visible");
        Assert.assertTrue(driver.findElement(By.id(cameraTitle)).isDisplayed(),"Cameras title is not present in toolbar");
        Assert.assertTrue(driver.findElement(By.id(playIcon)).isDisplayed(),"Live feed play icon is not visible");
        //Assert.assertTrue(driver.findElement(By.id(cameraTitle)).isDisplayed(),"Cameras title is not present in toolbar");
    }
}
