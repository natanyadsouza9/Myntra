package pom;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Utility;

public class CureFitHomePage {

	private AndroidDriver<MobileElement> driver;
	Utility utility=new Utility();

	@AndroidFindBy(xpath="//android.widget.TextView[@text='']")
	private MobileElement menuIcon;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Profile']")
	private MobileElement profileMenu;

	

	public CureFitHomePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickMenuIcon() {

		utility.addWait(driver, menuIcon);
		menuIcon.click();
	} 

	public void tapOnProfileMenu() {

		utility.addWait(driver, profileMenu);
		//profileMenu.click();
		utility.tapOnElement(driver, profileMenu);

	}


}
