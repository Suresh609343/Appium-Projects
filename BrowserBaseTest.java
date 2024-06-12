package mobilebrowser;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

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

public class BrowserBaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\sures\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4732).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Skemulatorr");
		options.setCapability("browserName", "Chrome");
//		options.setChromedriverExecutable("C:\\Users\\sures\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver = new AndroidDriver(new URI("http://127.0.0.1:4732").toURL(), options);
		
	}
	
//	@AfterClass
//	public void tearDown() {
//		
//		driver.quit();
//		service.stop();
//	}

}
