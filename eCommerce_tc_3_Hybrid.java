package skappium.AppiumFrameWorkDesign;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import skappium.AppiumFrameWorkDesign.pageObjects.android.FormPage;
import skappium.AppiumFrameWorkDesign.pageObjects.android.cartPage;
import skappium.AppiumFrameWorkDesign.pageObjects.android.productCatalogue;

public class eCommerce_tc_3_Hybrid extends BaseTest{
	
	@Test(dataProvider="getData")
	public void FilForm(String name, String gender, String country) throws InterruptedException {
		
		FormPage formPage = new FormPage(driver);
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountry(country);
		productCatalogue produccatelouge = formPage.letsShopButton();
		produccatelouge.addToCartAction(0);
		
		cartPage cartpage = produccatelouge.goToCart();
		cartpage.explictWait(cartpage.cartButton, "text", "Cart");
		
		cartpage.findSum();
		cartpage.getSumDisplayed();
		cartpage.acceptTermsConditions();
		cartpage.proceed();
		
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
	
	@DataProvider
	public Object[][] getData() {
		
		return new Object[][] { {"Kalpana","Female","Austria"} };
	}
	
	
}
