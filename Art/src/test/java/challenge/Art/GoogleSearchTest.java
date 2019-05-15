package challenge.Art;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchTest {
	WebDriver driver;
	//public static workbook book;
	
	@BeforeTest
	public void Config() {
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");	
	driver=new ChromeDriver();
	
	driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	
	driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void DynamicSearch() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
	WebElement ele=driver.findElement(By.xpath("//input[@title='Search']"));
	ele.sendKeys("java");
	Thread.sleep(3000);
	String beforeXpath="//li[";
	String afterXpath="]//div[1]//div[1]//div[1]//span[1]";   
     
	for(int i=1;i<=10;i++)
	{
		WebElement list=driver.findElement(By.xpath(beforeXpath+i+afterXpath));
		System.out.println(list.getText());
	if(list.getText().contains("javale mcgee")){
		list.click();
		break;
	}
	}
	}

	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}
}
