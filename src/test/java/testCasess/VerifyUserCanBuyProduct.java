package testCasess;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import BaseClasses.Drivers;
import pomClasses.CartPage;
import pomClasses.LoginPage;
import pomClasses.ProductDetails;
import pomClasses.homePage;



public class VerifyUserCanBuyProduct {
	
	WebDriver driver;
	LoginPage lp;
	homePage hp;
	ProductDetails pd;
	CartPage cp ;
	ExtentHtmlReporter htmlReporter;
	com.aventstack.extentreports.ExtentReports report            ;
	com.aventstack.extentreports.ExtentTest test;
	
	@BeforeClass
	public  void beforeClass() {
		htmlReporter = new ExtentHtmlReporter("ExtentReporter.html");
		report = new com.aventstack.extentreports.ExtentReports();
		report.attachReporter(htmlReporter);
		test = report.createTest("VerifyUserCanBuyProduct");
		
		
		 driver = Drivers.getDriver("edge");
		
	}

	
	@BeforeMethod
	public void  beforeMethod() {
		hp = new homePage(driver);
		lp = new LoginPage(driver);
		pd = new ProductDetails(driver);
		cp = new CartPage(driver);
	}
	
  @Test
public void verifyUserLogin() throws EncryptedDocumentException, IOException {
	  lp.putEmail();
	  lp.putPassword();
	  lp.clickLogin();
	  
	  SoftAssert Assert =  new SoftAssert();
	  Assert.assertTrue(hp.isProfileVisiable());
	  }
  
  @Test(priority=1)
public void verifyProductList() throws EncryptedDocumentException, IOException {
	 
	 String data = hp.getExcelData("Sheet1", 0, 1);
			  hp.enterSearchText(data);
			  hp.clickOnSearch();
	  Assert.assertTrue(hp.isProductListappeared());
  }
	
  @Test(priority=2)
public void  verifyUserSelectProductAndMoveToProductPage() {
	  hp.clickOnFirstProduct();
	  Assert.assertTrue(pd.productlist());
  }

  @Test(priority=3)
public void verifyUserClickOnCartAndMoveToCart() {
	  pd.clickOnAddToCart();
	  SoftAssert  Assert = new SoftAssert();
	  Assert.assertTrue(cp.myCartPage());
	  Assert.assertEquals(pd.productDetails(), cp.detailsOfProduct());
  }
	@Test(priority=4)
	public void verifyUserpincode() {
		cp.enterPinCode("444303");
		//Assert.assertEquals(cp.pinCodeDetails(), "Buldhana - 444303");
	}
  @Test(priority=5)
public void verifyUserCanPlaceOrder() {
	  cp.clickOnOrder(driver);
	  cp.selectAddress();
	  Assert.assertTrue(cp.ProductOutOfStock());
	  
  }
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName()+"Test is passed");
		}else {
			String path = hp.getScreenShot(driver, result.getName());
			test.log(Status.FAIL, result.getName()+"Test is failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	@AfterClass
	public void afterClass() {
		report.flush();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
}
