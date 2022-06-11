package utilClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilClasses {
	
	public static String getExcelData(String sheet, int j , int k) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("src\\main\\resources\\TestData\\Data.xlsx");
		String data =  WorkbookFactory.create(file).getSheet(sheet).getRow(j).getCell(k).getStringCellValue();
		return data;
	}
	
	
	public String getScreenShot(WebDriver driver,String Testname) throws IOException {
		SimpleDateFormat Frt = new SimpleDateFormat("dd-mm-yyyy-hh--mm");
		String date = Frt.format(new Date());
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = Testname+".png";
		File Desti =  new  File(path);
		
		org.openqa.selenium.io.FileHandler.copy(source, Desti);
		return path;
	}
	
	
	public static WebElement explicitWait(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement ele1 = wait.until(ExpectedConditions.visibilityOf(element));
		return ele1;
	}
	
	
}
