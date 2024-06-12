package skappium.AppiumFrameWorkDesign;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	@BeforeClass
	public void ConfigureClass() throws MalformedURLException, URISyntaxException {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\sures\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4732).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Skemulatorr");
		options.setApp("C:\\Users\\sures\\Appium\\appium\\src\\test\\java\\resources\\General-Store.apk");
		
		driver = new AndroidDriver(new URI("http://127.0.0.1:4732").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	

	
//	@AfterClass
//	public void tearDown() {
//		
//		service.stop();
//		driver.quit();
//		
//	}

}
