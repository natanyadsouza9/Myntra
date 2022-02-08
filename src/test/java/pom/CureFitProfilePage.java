package pom;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Utility;

public class CureFitProfilePage {

	
	private AndroidDriver<MobileElement> driver;
	Utility utility=new Utility();
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Blog']")
	private MobileElement blogSubMenu;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Workouts']")
	private MobileElement workoutsSubMenu;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Whoops!']")
	private MobileElement textOnBlogSubMenu;
	
	public CureFitProfilePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void tapOnBlogSubMenu() {

		
		utility.addWait(driver, workoutsSubMenu);
		//profileMenu.click();
		//blogSubMenu.click();
		utility.tapOnElement(driver, blogSubMenu);

	}

	public String verifyTextOnBlogSubMenu() {

		//utility.addWait(driver, blogSubMenu);
		//profileMenu.click();
		return textOnBlogSubMenu.getText();
	}
}
