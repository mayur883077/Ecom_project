package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Drivers {
	

		
	public static WebDriver getDriver(String k)
	{
		WebDriver driver=null;

		if(k.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\mayur\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
			 driver = new ChromeDriver();
		}else if(k.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\mayur\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
			 driver = new EdgeDriver();
		}
		
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
	      return driver;
		
	}
	}



