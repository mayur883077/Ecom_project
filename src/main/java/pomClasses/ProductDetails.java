package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.utilClasses;

public class ProductDetails extends utilClasses {
	WebDriver driver;
	@FindBy(xpath="//button[text()='BUY NOW']")
	private WebElement buyNowButton;
	@FindBy(xpath="//button[text()='ADD TO CART']")
	WebElement addToCardButton;
	@FindBy(xpath= "//span[@class='B_NuCI']")
	WebElement ProductDetails;
	

	public ProductDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

 public  boolean productlist() {
	 try {
		 WebElement ele = explicitWait(driver, buyNowButton);
		 return true;
	 }
	 catch(Exception e){
		 return false;
		 
	 }
 }
	 
	 public void clickOnAddToCart() {
		 addToCardButton.click(); 
	 }
	 public String productDetails() {
			try {
				WebElement ele =explicitWait(driver, ProductDetails);
				return ProductDetails.getText();		
			}
			catch(Exception e) {
				return "not appeared";
			}
 }
	
	
}
	

