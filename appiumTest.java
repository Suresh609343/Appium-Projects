package skappium.appium;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class appiumTest extends BaseTest{
	
	@Test
	public void WiFiSettings() throws MalformedURLException, URISyntaxException {
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc= '3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String alertTitle = driver.findElement(By.id("android:id/edit")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Skwifi");
		driver.findElement(By.id("android:id/button1")).click();
	
	}

}
