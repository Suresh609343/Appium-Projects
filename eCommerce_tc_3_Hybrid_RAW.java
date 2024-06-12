package generalStore.apk;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_3_Hybrid_RAW extends BaseTest{
	
	@Test
	public void FilForm() throws InterruptedException {
		
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kalpana");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Austria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		int addCart = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).size();
		
		for(int j =0; j<addCart; j++) {
			
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(j).click();
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeToBe(ele , "text", "Cart"));
		
		int valuesSize = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum=0.0;
		for(int i=0; i<valuesSize; i++) {
			
			sum = sum + Double.parseDouble((driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText()).substring(1));
		}
		
//		Assert.assertEquals(("$"+String.valueOf(sum)), driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText());
		
		System.out.println(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText());
		
		
		WebElement element = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		
		longClickGesture(element);
		
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(6000);
		
		Set<String> contexts = driver.getContextHandles();
		for(String context : contexts) {
			
			System.out.println(context);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.context("NATIVE_APP");
		
}
	}
