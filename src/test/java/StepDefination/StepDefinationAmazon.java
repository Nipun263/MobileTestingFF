package StepDefination;

import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.tools.ant.taskdefs.MacroDef.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationAmazon {

	public static AppiumDriver<MobileElement> driver;

	@Given("^User wants to login to Amazon$")
	public void user_wants_to_login_to_Amazon() throws Throwable {
		try {

			String ApplicationPath = System.getProperty("user.dir") + "\\Amazon_base.apk";
			DesiredCapabilities dcap = new DesiredCapabilities();
			dcap.setCapability("deviceName", "607e28cd"); // DeviceId from adb devices
			dcap.setCapability("platformName", "Android");
			dcap.setCapability("platformVersion", "11"); // Connected Mobile version
			dcap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
			dcap.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
			dcap.setCapability("app", ApplicationPath);

			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dcap);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		System.out.println("TestCase_1");
		Thread.sleep(2000);

		driver.navigate().back();
	}

	@Then("^User wants to verify the landing page$")
	public void user_wants_to_verify_the_landing_page() throws Throwable {
		List<MobileElement> homePageElements = driver
				.findElements(By.xpath("//android.view.View[contains(text(),'')]/android.widget.TextView"));

		Thread.sleep(5000);

		for (MobileElement ME : homePageElements) {
			String ElementPrsnt = ME.getText().toString();

			if (ElementPrsnt.contains("Electronics") || ElementPrsnt.contains("Mobiles") || !ElementPrsnt.isEmpty()) {
				// System.out.println("HomePage Verified");
				break;
			}

		}

		System.out.println("TestCase_2");
	}

	@And("^User wants to buy electronics good$")
	public void user_wants_to_buy_electronics_good() throws Throwable {

		try {
			List<MobileElement> homePageElements = driver
					.findElements(By.xpath("//android.view.View[contains(text(),'')]/android.widget.TextView"));

			for (MobileElement ME : homePageElements) {
				String ElementPrsnt = ME.getText().toString();
				// System.out.println(ElementPrsnt);

				if (ElementPrsnt.contains("Electronics")) {
					ME.click();
					// System.out.println("Electronics clicked");

				}
			}

		}

		catch (Exception e) {
			List<MobileElement> homePageElements = driver
					.findElements(By.xpath("//android.view.View[contains(text(),'')]/android.widget.TextView"));

		}

		System.out.println("TestCase_3");

		Thread.sleep(5000);
	}

	@Then("^User wants to buy SmartWatch$")
	public void user_wants_to_buy_SmartWatch() throws Throwable {
		try {

			List<MobileElement> ElectronicsPage = driver
					.findElements(By.xpath("//android.view.View[contains(text(),'')]/android.widget.TextView"));

			for (MobileElement ME : ElectronicsPage) {
				String ElementPrsnt = ME.getText().toString();

				// System.out.println("Electronics Items present :" + ElementPrsnt);

				if (ElementPrsnt.contains("Smartwatches")) {
					ME.click();
				}

			}
		} catch (Exception e) {

			List<MobileElement> ElectronicsPage = driver
					.findElements(By.xpath("//android.view.View[contains(text(),'')]/android.widget.TextView"));
		}

		System.out.println("TestCase_4");

		Thread.sleep(5000);
	}

	@And("^User wants to buy Garmin watch$")
	public void user_wants_to_buy_Garmin_watch() throws Throwable {
		Dimension dimension = driver.manage().window().getSize();
		TouchAction action = new TouchAction(driver);
		
		int height = (int) (dimension.getHeight());
		int width = (int) (dimension.getWidth());

		int start_X = width / 2;
		int end_X = width / 2; 
		int start_Y = (int) (height * 0.5);
		int end_Y = (int) (height * 0.20); 
		
		aa:
		
		for(;;) {

		List<MobileElement> Items = driver.findElements(By.className("android.widget.Image"));	
		
		for(MobileElement ME : Items) {
			
			String TextExtracted = ME.getText();
			
			
			if(!(TextExtracted.trim().equalsIgnoreCase("Shop by brand"))) {
				
				action.longPress(PointOption.point(start_X, start_Y)).moveTo(PointOption.point(end_X, end_Y))
				.release().perform();
				
			}
			
			else 
			{
				break;
			}
			
		}
				 
		
		}
		
		
	}
		
		
	@And("^User wants to apply filter for free Pay on Delivery$")
	public void user_wants_to_apply_filter_for_free_Pay_on_Delivery() throws Throwable {


		List<MobileElement> BrandNames = driver.findElements(By.xpath("//android.view.View[contains(content-desc,'')]/android.widget.Image"));
		int size = BrandNames.size();
		
		for (MobileElement ME : BrandNames) {
			String BrandNameText = ME.getText();

			System.out.println("Watches Brands are :" + BrandNameText);
		
		
		if(BrandNameText.equalsIgnoreCase("Noise")) {
			ME.click();
			System.out.println("Desired Watch Brand Selected");
			break;
		}
		
		
		
		
		}
		
	

			
		
	}

	@When("^System displays watches User want to select first watch$")
	public void system_displays_watches_User_want_to_select_first_watch() throws Throwable {

	}

	@And("^User wants to add it in card$")
	public void user_wants_to_add_it_in_card() throws Throwable {

	}
	
}
