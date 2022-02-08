package test;

import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pom.GoogleHomePage;
import pom.MyntraHomePage;
import pom.ProductPage;
import pom.ProductsListPage;

public class MyntraTests extends BaseTest  {

	GoogleHomePage googlehomePage;
	MyntraHomePage myntrahomePage;
	ProductsListPage productsListPage;
	ProductPage productPage;


	@Test
	public void challenge1() throws InterruptedException {

		googlehomePage=new GoogleHomePage(driver);
		myntrahomePage=new MyntraHomePage(driver);
		productsListPage=new ProductsListPage(driver);
		productPage=new ProductPage(driver);


	
		googlehomePage.enterSearchText("Myntra");
		googlehomePage.clickMyntraLink();
		Set<String> cns2 = driver.getContextHandles();

		System.out.println(cns2);
		driver.context("WEBVIEW_chrome");

		//myntrahomePage.clickMenuIcon();

		//myntrahomePage.loginToMyntra();
		driver.manage().deleteAllCookies();
		Thread.sleep(10000);
		myntrahomePage.clickOnSearchIcon();

		myntrahomePage.closePopUp();

		myntrahomePage.searchProduct("Nike Shoes Women");
		
		//myntrahomePage.closePopUp();
		//driver.context("NATIVE_APP");

		//Thread.sleep(5000);

		//productsListPage.longPressOnFirstDisplayedProduct();
		Thread.sleep(3000);

		productsListPage.tapOnFirstDisplayedProduct();
		productPage.tapOnProduct();
		productPage.swipeProduct();
		//Thread.sleep(5000);
		productPage.tapOnDisplayedImage();
		productPage.tapOnDisplayedImage();
		productPage.clickOnCloseButton();
		productPage.tapOnAddToBag();
		productPage.selectFirstSize();
		String actualBagCount=productPage.verifyBagCount();
		Assert.assertEquals("1", actualBagCount,"bag count is not the expected value of 1");
		Reporter.log("actual bag count value= "+actualBagCount);
		Reporter.log("expected bag count value= 1");

		productPage.tapOnBagIcon();
		//driver.switchTo().alert().accept();


	}
}
