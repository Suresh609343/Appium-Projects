package skappium.appium;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class longPressTest extends BaseTest{
	
	@Test
	public void LongPressTest() throws MalformedURLException, URISyntaxException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		longPressAction(ele);
		
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		
		Assert.assertEquals(menuText, "Sample menu");
		
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		
		
	}

}
