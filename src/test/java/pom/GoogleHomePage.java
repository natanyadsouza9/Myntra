package pom;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GoogleHomePage {

	private AndroidDriver<MobileElement> driver;

	
	  @AndroidFindBy(id="com.android.chrome:id/search_box_text") private
	  MobileElement searchTextBox;
	  
	  @AndroidFindBy(xpath="//android.view.View[@text='Myntra']") private
	  MobileElement myntraLink;
	 
	


	public GoogleHomePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	public void enterSearchText(String searchtext) {

		searchTextBox.sendKeys(searchtext);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

	}

	public void clickMyntraLink() {

		myntraLink.click();
	}
}
