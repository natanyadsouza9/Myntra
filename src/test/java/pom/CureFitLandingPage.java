package pom;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CureFitLandingPage {


	private AndroidDriver<MobileElement> driver;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='LOG IN']")
	private MobileElement logInLink;



	public CureFitLandingPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickLogInLink() {
		
		logInLink.click();
	}

}
