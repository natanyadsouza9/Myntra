package test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.appmanagement.ApplicationState;
import pom.CureFitHomePage;
import pom.CureFitLandingPage;
import pom.CureFitLoginPage;
import pom.CureFitProfilePage;

public class CureFitTests extends BaseTest {

	@Test
	public void Challenge2() throws InterruptedException {

		Set<String> cns2 = driver.getContextHandles();
		System.out.println(cns2);

		CureFitLandingPage landingPage=new CureFitLandingPage(driver);
		CureFitLoginPage loginPage=new CureFitLoginPage(driver);

		landingPage.clickLogInLink();
		loginPage.loginToCureFitApp();

		//send app to the background and bring it back after 5 seconds
		driver.runAppInBackground(Duration.ofSeconds(5));

		//check the app status
		ApplicationState state=driver.queryAppState("curefit.me");
		Reporter.log("appState="+state.toString());
		
		//terminate the app
		//driver.terminateApp("curefit.me");



	}
	
	@Test
	public void Challenge3() throws InterruptedException {

		
		//driver.launchApp();

		CureFitLandingPage landingPage=new CureFitLandingPage(driver);
		CureFitLoginPage loginPage=new CureFitLoginPage(driver);
		CureFitHomePage homePage=new CureFitHomePage(driver);


		landingPage.clickLogInLink();
		loginPage.loginToCureFitApp();
		homePage.clickMenuIcon();
		homePage.tapOnProfileMenu();
	
		
		CureFitProfilePage profilePage=new CureFitProfilePage(driver);

		profilePage.tapOnBlogSubMenu();
		String actualText=profilePage.verifyTextOnBlogSubMenu();
		Assert.assertEquals("Whoops!", actualText,"text does not match expectedValue=Whoops!");
		Reporter.log("actualText="+actualText);
		Reporter.log("expectedText=Whoops!");



	}
	
	@Test
	public void Challenge4() throws InterruptedException {

		CureFitLandingPage landingPage=new CureFitLandingPage(driver);
		CureFitLoginPage loginPage=new CureFitLoginPage(driver);

		landingPage.clickLogInLink();
		loginPage.loginToCureFitApp();

		List<String> li= driver.getSupportedPerformanceDataTypes();
		 System.out.println(li);


			Reporter.log("batteryinfo="+driver.getPerformanceData("curefit.me","batteryinfo",5));
			Reporter.log("cpuinfo="+driver.getPerformanceData("curefit.me","cpuinfo",5));
			Reporter.log("memoryinfo="+driver.getPerformanceData("curefit.me","memoryinfo",5));
			Reporter.log("networkinfo="+driver.getPerformanceData("curefit.me","networkinfo",5));


	}
}
