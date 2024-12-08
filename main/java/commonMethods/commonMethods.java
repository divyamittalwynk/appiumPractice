package commonMethods;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class commonMethods {

    public Object waitForElement(String locator,WebDriverWait wait) {
        try{

            if (locator.contains("//")) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            }
            else {
                wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
            }
        }
        catch (Exception e) {
            return null;
        }

        return null;

    }

    public  void MobileElementClick(String element, AndroidDriver driver) {
        WebElement e = null;
        if (element.contains("//")) { //for xpath
            e = driver.findElement(By.xpath(element));

        } else if (element.startsWith(".")) {// for class
            e = driver.findElement(By.className(element));
        } else { //for id
            e = driver.findElement(By.id(element));
        }
        e.click();
    }

    public void sendKeys(String input, String locator, AndroidDriver driver) {

        if (locator.contains("//")) {
            driver.findElement(By.xpath(locator)).sendKeys(input);
        }
        else {
            driver.findElement(By.id(locator)).sendKeys(input);
        }

    }

    public void startActivity(AndroidDriver driver, String appPackageName, String appActivityName) {
        Activity activity = new Activity(appPackageName,appActivityName);
        driver.executeScript("mobile:startActivity", ImmutableMap.of("intent","com.airtel.xsafe/com.airtel.xsafesdk.ui.activity.HomeActivity"));
//        driver.startActivity(activity);

    }




}
