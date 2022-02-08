package pom;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Utility;

public class ProductsListPage {

	private AndroidDriver<MobileElement> driver;
	Utility utility=new Utility();

	@FindBy(xpath="//picture[@class='img-responsive']")
	private MobileElement firstProduct;

	public ProductsListPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void longPressOnFirstDisplayedProduct() {

		utility.addWait(driver, firstProduct);
		utility.longPressUsingPoint(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utility.tapOnCoordinate(driver,135,700);

	}

	public void tapOnFirstDisplayedProduct() {

		//utility.addWait(driver, firstProduct);
	
		utility.tapOnCoordinate(driver,135,700);



	}


}
