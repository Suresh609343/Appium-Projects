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

public class DragDropTest extends BaseTest{
	
	@Test
	public void DragDropDemo() throws MalformedURLException, URISyntaxException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement ele = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		DragDropAction(ele,833,740);
		
		String DropO = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println(DropO);
		Assert.assertEquals(DropO, "Dropped!");
	}
}
