package pomClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.utilClasses;

public class homePage extends utilClasses {
	WebDriver driver;
	
	
	
	@FindBy(xpath="//div[text()='Profile']")
	private WebElement profileName;
	
	@FindBy(xpath="//input[@class='_3704LK']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchButton;
	@FindBy(xpath="(//div[@class=\"_2kHMtA\"])[1]")
	private WebElement productList;
	
	
public homePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;

}
	public void enterSearchText(String search) throws EncryptedDocumentException, IOException {
		try {
			WebElement element = explicitWait(driver, searchField);
		element.sendKeys(search);
		}catch(Exception e) {}
	}
	
	public void clickOnSearch() {
		searchButton.click();	
	}
	
	public boolean isProductListappeared() {
		try {
			WebElement ele = explicitWait(driver, productList);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean isProfileVisiable() {
		try{
			WebElement  ele = explicitWait(driver,profileName);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public void clickOnFirstProduct() {
		productList.click();
		
		List<String> webPage = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(webPage.get(1));
	}
}





