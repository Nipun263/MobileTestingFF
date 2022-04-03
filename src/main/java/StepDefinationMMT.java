

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class StepDefinationMMT {

	public static AppiumDriver<MobileElement> driver;

	@io.cucumber.java.en.Then("^User should pass the Login details$")
	public void user_should_pass_the_Login_details() throws Throwable {
		try {

			String ApplicationPath = System.getProperty("user.dir") + "\\MMT3.apk";
			DesiredCapabilities dcap = new DesiredCapabilities();
			dcap.setCapability("deviceName", "emulator-5554"); // DeviceId from adb devices
			dcap.setCapability("platformName", "Android");
			dcap.setCapability("platformVersion", "11"); // Connected Mobile version
			dcap.setCapability("appPackage", "com.makemytrip");
			dcap.setCapability("appActivity", "com.mmt.travel.app.home.ui.SplashActivity");
			dcap.setCapability("app", System.getProperty("user.dir") + "\\" + "MMT3.apk");

			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dcap);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		System.out.println("TestCase_1");
		Thread.sleep(5000);
		driver.navigate().back();

		Thread.sleep(8000);

		/*
		 * if(driver.findElement(By.xpath(
		 * "//*[@id='screenshotContainer']/div/div/div/div/div/div[28]")).isDisplayed())
		 * { System.out.print("Alert Handled"); Alert alert = driver.switchTo().alert();
		 * alert.dismiss(); }
		 */

	}

	@io.cucumber.java.en.Then("^Lands on HomePage$")
	public void HomePageValidation() throws Throwable {
		try {
			Boolean flag = driver.findElement(By.xpath(
					"hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.TextView"))
					.isDisplayed();

			Assert.assertTrue(flag);
		} catch (Exception e) {
			System.out.print(e.getStackTrace());
		}

	}

	@io.cucumber.java.en.Then("^User clicks on flights Icon$")
	public void BookFlight() throws Throwable {

		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath(
					"hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.view.ViewGroup/android.widget.TextView"))
					.click();

			Thread.sleep(5000);

			Boolean flag = driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[1]"))
					.isDisplayed();

			Assert.assertTrue(flag);

			driver.findElement(By.xpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.RelativeLayout"))
					.click();
			Thread.sleep(5000);

			driver.findElement(By.id("com.makemytrip:id/departure_city_input")).sendKeys("Mumbai");
		} catch (Exception e) {
			System.out.print(e.getStackTrace());
		}

		System.out.print("BYPASS");
		;
	}

	@io.cucumber.java.en.Then("^User should be able to pass flight details to book$")
	public void FlightDetails() throws Throwable {

		try {

			List<MobileElement> fromFlightsListed = driver.findElements(By.className("android.widget.TextView"));
			int size_FromStationListed = fromFlightsListed.size();

			for (MobileElement ME : fromFlightsListed) {
				String fromStationPopulated = ME.getText().toString();

				// System.out.println(fromStationPopulated + " ");

				if (fromStationPopulated.trim().contains("Mumbai")) {
					ME.click();
					System.out.println("Desired From station selected" + "   ");
					break;
				}
			}

			driver.findElement(By.id("com.makemytrip:id/arrival_city_input")).sendKeys("Chennai");

			List<MobileElement> TOFlightsListed = driver.findElements(By.id("com.makemytrip:id/title"));

			for (MobileElement ME : TOFlightsListed) {
				String TOFlightsPopulated = ME.getText().toString();

				// System.out.println(TOFlightsPopulated + " ");

				if (TOFlightsPopulated.contains("Chennai")) {
					ME.click();
					System.out.println("Desired To station selected" + "   ");

					break;
				}
			}

		} catch (Exception e) {
			System.out.print(e.getStackTrace());
		}

	}

	@io.cucumber.java.en.Then("^User should able to search the flight$")
	public void SearchDesiredFlight() throws Throwable {

		Dimension dimension = driver.manage().window().getSize();

		int height = (int) (dimension.getHeight());
		int width = (int) (dimension.getWidth());

		int start_X = width / 2; // Taking the half of the screen as we will scroll from middle(Widht)
		int end_X = width / 2; // End will be same as start_x as the user will scroll using midle as ref
		int start_Y = (int) (height * 0.5); // kis height se start karna hai
		int end_Y = (int) (height * 0.10); // kis height tak scroll karna h

		try {
			Thread.sleep(3000);
			driver.findElement(By.id("com.makemytrip:id/constraintLayout5")).click();

			List<MobileElement> Month1 = driver.findElements(By.id("com.makemytrip:id/tv_month"));
			
			aa:  
				  
			for(;;) {
				List<MobileElement> Month = driver.findElements(By.id("com.makemytrip:id/tv_month"));

				for (MobileElement ME : Month) {
					String Month_Extracted = ME.getText();

					if (!Month_Extracted.contains("August")) {
						TouchAction action = new TouchAction(driver);
						action.longPress(PointOption.point(start_X, start_Y)).moveTo(PointOption.point(end_X, end_Y))
								.release().perform();
						Thread.sleep(2000);

					}

					else {
						System.out.println(Month_Extracted);
						break aa;

					}

				}

			}
		}

		catch (Exception e) {

			List<MobileElement> Month = driver.findElements(By.id("com.makemytrip:id/tv_month"));
			int size = Month.size();

					for(MobileElement ME : Month) {
					String Month_Extracted = ME.getText();

					if (Month_Extracted.contains("August")) {
						System.out.println(Month_Extracted);
					}
					

					else if (!Month_Extracted.contains("August")) {
						TouchAction action = new TouchAction(driver);

						action.longPress(PointOption.point(start_X, start_Y)).moveTo(PointOption.point(end_X, end_Y))
								.release().perform();
						Thread.sleep(2000);
					}

				}

			}
		
		//Selecting the desired date and click on Done 
		
		List<MobileElement> dates = driver.findElements(By.className("android.view.View"));
		int sizee = dates.size();
		
		for(int i = 0 ; i <dates.size();i++ ) {
			String DD = dates.get(i).getText().toString();
			
			System.out.print(DD);
		}
		
		MobileElement DoneBtn = driver.findElement(By.id("com.makemytrip:id/btnDone"));
		DoneBtn.click();
		

		}

	

	
	@io.cucumber.java.en.Then("^User clicks on first flight in the search list$")
	public void SelectFirstFlight() throws Throwable {
		MobileElement SerachFlightBtn = driver.findElement(By.id("com.makemytrip:id/search_button_flat"));
		SerachFlightBtn.click();
		Thread.sleep(2000);
		
		Boolean State = driver.findElement(By.id("com.makemytrip:id/ivFareMonth")).isDisplayed();
		Assert.assertTrue(State);
		
		
		MobileElement TopMostFlight = driver.findElement(By.id("com.makemytrip:id/top_area"));
		TopMostFlight.click();
		Thread.sleep(2000);
		
		MobileElement BookNow = driver.findElement(By.id("com.makemytrip:id/btnBookNow"));
		BookNow.click();
	}

	@io.cucumber.java.en.Then("^User should be allowed to pass Passenger details and Book ticket$")
	public void PassengerCredentials() throws Throwable {

	}

}
