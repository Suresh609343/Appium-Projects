package skappium.appium;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class AppiumAssingment extends BaseTest{
	
	@Test
	public void swipeDemoTest() throws MalformedURLException, URISyntaxException {
		
		driver.findElement(AppiumBy.accessibilityId("App")).click(); driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click(); 
		
		//1 
		
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.id("android:id/button1")).click(); 
		
		//2 
		
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.id("android:id/button1")).click(); 
		
		//3 
		
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click(); 
		
		WebElement ele = driver.findElement(By.id("android:id/message")); 
		
		boolean canScrollMore; 
		
		do{ 
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of( 
					"elementId", ele, 
					"direction", "down", 
					"percent", 1.0 
					)); 
			} while(canScrollMore); 
		driver.findElement(By.id("android:id/button1")).click();
		
		//4
		
//		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		driver.findElement(By.id("android:id/text1")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		System.out.println(driver.findElement(By.id("android:id/message")).getText());
		
		//5
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Satellite']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.id("android:id/button1")).click();
		
		//6
		
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Every Monday']")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Every Wednesday']")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Every Friday']")).click();
		
		driver.findElement(By.id("android:id/button1")).click();
		
		//7
		
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Suresh Kumar");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("MG");
		driver.findElement(By.id("android:id/button1")).click();
		
		//8
		
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with traditional theme")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.id("android:id/button1")).click();
		
	}
}
