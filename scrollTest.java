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

public class scrollTest extends BaseTest{
	
	@Test
	public void scrollDemoTest() throws MalformedURLException, URISyntaxException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView2\"));"));
		
//		WebElement ele = driver.findElement(AppiumBy.accessibilityId("WebView"));
//		
//		boolean canScrollMore;
//		
//		do {
//		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//		    "elementId", ((RemoteWebElement)ele).getId(),
//		    "direction", "down",
//		    "percent", 1.0
//		));
//		} while(canScrollMore);
	}
}
