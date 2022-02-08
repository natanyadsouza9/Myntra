package utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Utility {

	AndroidDriver<MobileElement> driver;

	public void setCapabilityForMobile(String deviceName,String platformName,String platformVersion,String url,String appPackage,String appActivity) throws MalformedURLException{

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		cap.setCapability("autoAcceptAlerts", true);
		//cap.setAcceptInsecureCerts(true);
		//caps.setCapability("autoGrantPermissions", "true");

		//cap.setCapability("chromedriverExecutable","C:\\Users\\natan\\edureka\\cucumberBDD\\drivers\\chromedriver.exe");

		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability("chromedriverExecutable","C:\\Users\\natan\\edureka\\appiumCourse\\FinalAppiumProject\\drivers\\chromedriver.exe");
		driver= new AndroidDriver<MobileElement>(new URL(url),cap);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public AndroidDriver<MobileElement> getDriver() {

		return driver;
	}

	public void longPressUsingPoint(WebDriver driver2) {

		TouchAction ta = new TouchAction((PerformsTouchActions) driver2);
		ta.longPress(PointOption.point(230,942)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.release().perform();
	}


	public void tapOnCoordinate(WebDriver driver2,int x,int y) {

		TouchAction ta = new TouchAction((PerformsTouchActions) driver2);
		ta.tap(PointOption.point(x,y)).release().perform();

	}

	public void tapOnElement(AndroidDriver<MobileElement> driver,MobileElement element) {

		TouchAction ta = new TouchAction(driver);
		  ta.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();

	}

	

	public void addWait(WebDriver driver,MobileElement element) {

		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void swipeScreen(AndroidDriver<MobileElement> driver,int x1,int y1,int x2,int y2 ) {

		TouchAction ta = new TouchAction(driver);

		ta.longPress(PointOption.point(x1,y1))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(x2,y2)).release()
		.perform();

	}

	public void pressOnCoordinates(AndroidDriver<MobileElement> driver,int x,int y) {

		TouchAction ta = new TouchAction(driver);
		ta.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().perform();

	}
	


	public void clickElementUsingJavascriptExecutor(AndroidDriver<MobileElement> driver,MobileElement element) {


		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
}
