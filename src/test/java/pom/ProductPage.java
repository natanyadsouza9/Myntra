package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Utility;

public class ProductPage {

	private AndroidDriver<MobileElement> driver;
	Utility utility=new Utility();

	@FindBy(css="div.ripple-container.popup-close.left")
	private MobileElement closeButton;

	@FindBy(xpath="//picture[@class='img-responsive']")
	private MobileElement product;

	@FindBy(css="span.icon.navigator.right")
	private MobileElement navigatorRight;

	@FindBy(xpath="//div[@class='width-60']")
	private MobileElement addToBagButton;

	@FindBy(css="button.btn.primary.flex.center.full-width")
	private MobileElement addToBagButton2;

	@FindBy(xpath="//button[text()='DONE']")
	private MobileElement doneButton;

	@FindBy(xpath="//div[@class='width-60']")
	private MobileElement goToBagButton;

	@FindBy(xpath="//a[@id='header-cart-icon']")
	private MobileElement bagIcon;

	//@FindBy(css="button.btn.default.outline.size-btn")
	//@FindBy(xpath="(//button[contains(@class,'size-btn')])[2]")
	@FindBy(xpath="//button[contains(@class,'size-btn') and not(contains(@class,'disabled'))]")
	private MobileElement firstSizeButton;

	@FindBy(xpath="//span[@class='badge']")
	private MobileElement bagCount;


	public ProductPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void swipeProduct() {

		utility.addWait(driver, navigatorRight);
		utility.swipeScreen(driver, 871, 675, 169, 675);

		
		  driver.context("NATIVE_APP");
		  driver.findElementById("com.android.chrome:id/negative_button").click();
		  driver.context("WEBVIEW_chrome");
		 
		utility.addWait(driver, navigatorRight);

		utility.swipeScreen(driver, 871, 675, 169, 675);

	}

	public void tapOnProduct() {

		utility.addWait(driver, addToBagButton);

		utility.tapOnCoordinate(driver,871,905);
	}

	public void tapOnDisplayedImage() {

		//utility.addWait(driver, navigatorRight);

		utility.tapOnCoordinate(driver,871,905);
	}

	public void clickOnCloseButton() {

		utility.addWait(driver, closeButton);
		closeButton.click();

	}

	public void tapOnAddToBag() {


		utility.addWait(driver, addToBagButton);
		//utility.clickElementUsingJavascriptExecutor(driver, addToBagButton);		
		//utility.tapOnElement(driver, addToBagButton);
		utility.tapOnCoordinate(driver, 773, 1835);

	}

	public void selectFirstSize() {


		utility.addWait(driver, doneButton);
		//utility.clickElementUsingJavascriptExecutor(driver, firstSizeButton);
		firstSizeButton.click();
		utility.addWait(driver, doneButton);
		utility.tapOnCoordinate(driver, 538, 1817);
		//utility.tapOnElement(driver, doneButton);
		//doneButton.click();
	}

	public String verifyBagCount() {


		utility.addWait(driver, goToBagButton);
		return bagCount.getText();


	}

	public void tapOnBagIcon() {

		//utility.tapOnElement(driver, bagIcon);
		bagIcon.click();

	}



}
