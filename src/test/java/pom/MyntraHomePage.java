package pom;

import java.time.Duration;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Utility;

public class MyntraHomePage {

	private AndroidDriver<MobileElement> driver;
	Utility utility=new Utility();

	@FindBy(xpath="//a[@id='header-search-icon']")
	private MobileElement searchIcon;

	@FindBy(xpath="//input[contains(@placeholder,'Search')]")
	private MobileElement searchTextBox;
	
	@FindBy(css=".ripple-container.popup-close.right")
	private MobileElement popUpCloseButton;
	
	@FindBy(xpath="//div[@id='header-menu-icon']")
	private MobileElement menuIcon;
	
	@FindBy(xpath="//div[@class='logoutButtonContainer']/a")
	private MobileElement loginLink;
	
	@FindBy(css="input.form-control.mobileNumberInput")
	private MobileElement mobileNoTextBox;
	
	@FindBy(css="div.submitBottomOption")
	private MobileElement continueButton;
	
	@FindBy(xpath="//div[@class='bottomeLink']/span")
	private MobileElement passwordLink;
	
	@FindBy(xpath="//input[@type='password']")
	private MobileElement passwordTextBox;
	
	@FindBy(css="button.submitButton")
	private MobileElement loginButton;

	public MyntraHomePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickOnSearchIcon() {

		utility.addWait(driver, searchIcon);
		searchIcon.click();
		//driver.findElementsByClassName("android.widget.Image").get(1).click();
		//driver.findElementByXPath("//android.view.View[@content-desc=\"autosuggest\"]/android.widget.Image").click();
	}

	public void clickOnSearchTextBox() {

		utility.addWait(driver, searchTextBox);

		searchTextBox.click();
	}

	public void searchProduct(String productName) {

		searchTextBox.sendKeys(productName);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		

	}
	
	public void closePopUp() {

		utility.addWait(driver, popUpCloseButton);
		popUpCloseButton.click();
		

	}
	
	public void clickMenuIcon() {

		menuIcon.click();
		
	}

	public void loginToMyntra() throws InterruptedException {

		loginLink.click();
		Thread.sleep(5000);
		mobileNoTextBox.sendKeys("9881638162");
		continueButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		passwordLink.click();
		passwordTextBox.sendKeys("Natanya9#");
		loginButton.click();
		
	}
	
	
}
