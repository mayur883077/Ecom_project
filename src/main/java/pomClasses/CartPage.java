package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.utilClasses;

public class CartPage extends utilClasses {
	WebDriver driver;
	@FindBy(xpath="//div[contains(text(),'My Cart')]")
	WebElement myCart;
	@FindBy(xpath="//a[@class='_2Kn22P gBNbID']")
	WebElement product;
	@FindBy(xpath="//button[@class='_2MMH-I']")
	WebElement pinCode;
	@FindBy(xpath="//input[@class='_3gwHKm']")
	WebElement pincodeField;
	@FindBy(xpath="//div[text()='Submit']")
	WebElement pinSubmit;
	@FindBy(xpath="(//button[contains(@class,'_2KpZ6l')])[2]")
	WebElement Address;
	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	WebElement placeOrder;
	@FindBy(xpath="//div[@class='_1XFPmK']")
	WebElement Addresses;
	@FindBy(xpath="//button[text()='Deliver Here']")
	WebElement OderOnAddress;
	@FindBy(xpath="//input[@type='email']")
	WebElement enterEmail;
	@FindBy(xpath="//button[@class='_2KpZ6l _1seccl _3AWRsL']")
	WebElement continueButton;
	@FindBy(xpath="//div[@class='_1tBBEs']")
	WebElement outOfStock;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public boolean myCartPage() {
		try {
		WebElement ele = explicitWait(driver, myCart);
		return true;
		}
		catch(Exception e) {
		return false;
		}
	}
	
	public String detailsOfProduct() {
		try { 
			WebElement ele = explicitWait(driver, product);
			return product.getText();
		}
		catch(Exception e){
			return "";	
		}}
	
	public void enterPinCode(String pin) {
		pinCode.click();
		WebElement ele = explicitWait(driver, pincodeField);
		ele.sendKeys(pin);
		WebElement ele1 = explicitWait(driver, pinSubmit);
		ele1.click();
	}
		
	public  String pinCodeDetails() {
		WebElement ele = explicitWait(driver, Address);
		return ele.getText();
		
	}
	public void clickOnOrder(WebDriver driver) {
		
		WebElement ele = explicitWait(driver, placeOrder);
		//driver.switchTo().activeElement();
		ele.click();
	}
	public void selectAddress() {
		WebElement ele = explicitWait(driver, Addresses);
		ele.click();
		WebElement ele2 = explicitWait(driver, OderOnAddress);
		ele2.click();
		WebElement ele1 = explicitWait(driver, enterEmail);
		ele1.sendKeys("mayursraut97@gmail.com");
		continueButton.click();
	}
	public boolean ProductOutOfStock() {
		try {
			WebElement ele = explicitWait(driver, outOfStock);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
		
		
	}
 
