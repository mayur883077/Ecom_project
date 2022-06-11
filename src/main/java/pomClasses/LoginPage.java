package pomClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.utilClasses;

public class LoginPage extends utilClasses {

		WebDriver driver;

		@FindBy(xpath="(//input[@type='text'])[2]")
		private WebElement email;
		
		@FindBy(xpath="//input[@type='password']")
		private WebElement password;
		
		@FindBy(xpath="(//button[@type='submit'])[2]")
		private WebElement loginButton;
		
		
		public  LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver = driver;
			
		}
		
		
		
   public void putEmail() throws EncryptedDocumentException, IOException {
	   email.sendKeys(getExcelData("Sheet1", 0, 0));
   }  
   
  public void  putPassword() throws EncryptedDocumentException, IOException{
	  password.sendKeys(getExcelData("Sheet1", 1, 0));
    }
	
  public void clickLogin() {
	  loginButton.click(); 
  }
	 	
}






