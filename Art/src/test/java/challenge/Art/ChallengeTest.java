package challenge.Art;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChallengeTest {

	WebDriver driver;
	String text,text1;
	/*
	 * @Test(priority=1) public void config() {
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe"); driver = new
	 * ChromeDriver(); driver.get("https://www.zoopla.co.uk/");
	 * //driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); }
	 
		
		@Test(priority=5)
		public void CloseBrowser() {
			driver.quit();
			}*/
		
		@Test(priority=2)
		public void MainPage() {
			driver.findElement(By.xpath("//input[@id='search-input-location']")).sendKeys("london");
			driver.findElement(By.xpath("//button[@id='search-submit']")).click();
		}
		
		@Test(priority=3)
		public void SearchResults() throws InterruptedException {
			Select results_sort=new Select(driver.findElement(By.xpath("//select[@name='results_sort']")));
			results_sort.selectByVisibleText("Highest price");
			String beforeXpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/ul[1]/li[";

			String afterXpath = "]/div[1]/div[2]/a[1]";

			for(int i=1; i<=3;i++){

			WebElement element=driver.findElement(By.xpath(beforeXpath+i+afterXpath));
			text=element.getText();
			//System.out.println(text);

			if(i==3){
			element.click();
			System.out.println(text);
			System.out.println(driver.findElement(By.xpath("//div[@class='ui-agent__logo']")));
			}
			}

			Thread.sleep(2000);
		}

		@Test(priority=4)
		public void verification() throws InterruptedException {
			WebElement ele1= driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]/h4[1]"));
			ele1.click();

	Thread.sleep(2000);
	try {
	
		
		text1=driver.findElement(By.cssSelector("//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']]")).getText();
	
		Assert.assertEquals(text1, text );}
	catch(Exception e) {
		System.out.println("Not Verified");
	}}
	}


