

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class StepDefination {
	
	public static AppiumDriver<MobileElement> driver;

	@Test
	public void LoginDetails() throws Throwable {
		try {

			String ApplicationPath = System.getProperty("user.dir") + "\\Amazon_base.apk";
			DesiredCapabilities dcap = new DesiredCapabilities();
			dcap.setCapability("deviceName", "607e28cd"); // DeviceId from adb devices
			dcap.setCapability("platformName", "Android");
			dcap.setCapability("platformVersion", "11"); // Connected Mobile version
			dcap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
			dcap.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
			dcap.setCapability("app", System.getProperty("user.dir") + "\\" + "MMT3.apk");

			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dcap);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		System.out.println("TestCase_1");
		Thread.sleep(5000);
	}
	
	List<MobileElement> primeMember = driver.findElements(By.className("android.webkit.WebView"));
	

}
