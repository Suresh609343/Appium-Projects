package skappium.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscalleanousActions extends BaseTest{
	
	@Test
	public void MiscalleanousActionsDemo() {
		
		//Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
				"intent" ,"io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"
			));
		
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		
		driver.findElement(By.id("android:id/checkbox")).click();
		
		driver.rotate(ScreenOrientation.LANDSCAPE);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		driver.setClipboardText("SureshWifi");
		
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		driver.rotate(ScreenOrientation.PORTRAIT);
		
//		driver.findElement(By.id("android:id/button1")).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
