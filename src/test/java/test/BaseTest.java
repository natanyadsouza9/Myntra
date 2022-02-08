package test;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utility.Utility;

public class BaseTest {

	AndroidDriver<MobileElement> driver;
	Utility utils = new Utility();



	@Parameters({"deviceName","platformName","platformVersion","url","appPackage","appActivity"})
	@BeforeTest
	public void mobileSetUp(String deviceName, String platformName, String platformVersion, String url,String appPackage,String appActivity) throws MalformedURLException  {


		utils.setCapabilityForMobile(deviceName, platformName, platformVersion, url,appPackage,appActivity);
		driver=utils.getDriver();

	}

	
	
	  @BeforeMethod public void launchApp() {
	  
	  driver.launchApp();
	  
	  }
	  
	  @Parameters({"appPackage"})
	  
	  @AfterMethod public void terminateApp(String appPackage) {
	  
	  driver.terminateApp(appPackage);
	  
	  }
	 
	 

}
