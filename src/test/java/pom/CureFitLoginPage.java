package pom;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CureFitLoginPage {

	private AndroidDriver<MobileElement> driver;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email']")
	private MobileElement emailTextBox;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Password']")
	private MobileElement passwordTextBox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ENTER']")
	private MobileElement enterButton;

	public CureFitLoginPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void loginToCureFitApp() {
		
		emailTextBox.sendKeys("natanyadsouza9@gmail.com");
		passwordTextBox.sendKeys("Natanya9#");
		enterButton.click();
	}
}
