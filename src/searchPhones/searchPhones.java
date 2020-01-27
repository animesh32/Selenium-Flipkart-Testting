package searchPhones;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchPhones {
	public static WebDriver driver;
	
	public static void load_web() {
		System.setProperty("webdriver.chrome.driver","/home/animesh/eclipse-workspace/Flipkart/chrome driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
	}
	
	public static void main(String[] args) throws InterruptedException{
		String username="";
		String password=""; 
		load_web();
		driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ'][1]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", "User Not successfily signed in");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more'][1]")).sendKeys("Realme XT");
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getTitle(),"Realme XT - Buy Products Online at Best Price in India - All Categories | Flipkart.com", "Phones page not loaded");
		driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[2]//div[1]//div[1]//div[1]//a[1]//div[1]//div[1]//div[1]")).click();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		WebElement price = driver.findElement(By.xpath("//div[@class='_1vC4OE _3qQ9m1']"));
		System.out.println("Price of Realme XT mobile is" +price.getText());
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		driver.close();
		
		
	}
	

}
