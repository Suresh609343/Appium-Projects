package mobilebrowser;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class mobileBrowser extends BrowserBaseTest{
	
	@Test
	public void mobileDemo() throws MalformedURLException, URISyntaxException {
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.findElement(By.cssSelector("button[aria-label='Toggle navigation']")).click(); 
		driver.findElement(By.xpath("//a[@href='/angularAppdemo/products']")).click(); 
		
		// this is a a scroll that works only on NATIVE APPS. 
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Devops\"));")); 
		
		// this is a scroll that works on webview apps/webview pages. 
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 1000)", ""); 
		String text = driver.findElement(By.xpath("//a[@href='/angularAppdemo/products/3']")).getText(); 
		Assert.assertEquals(text, "Devops");
	
	}

}
