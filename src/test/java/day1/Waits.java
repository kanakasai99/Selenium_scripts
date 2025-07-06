package day1;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		//WebDriver driver=new ChromeDriver();
		
		//Explicit wait declaration
		//WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebDriverWait mywait= new WebDriverWait(driver,Duration.ofSeconds(10)); //Declaration
		WebElement username= mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys("Admin");
				
		
			
		/*//usage of explicit wait
		WebElement textusername=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		textusername.sendKeys("Admin");
		
		WebElement textpwd=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		textpwd.sendKeys("admin123");

		WebElement loginButton=mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		loginButton.click();*/
		
		/*Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(10))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);*/
		
		/*driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.manage().window().maximize();	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
			
		
		 WebElement txtusername = mywait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       WebElement txtusername=driver.findElement(By.xpath("//input[@placeholder='Username']"));
			       return txtusername;
			     }
			   });

		   
		 txtusername.sendKeys("Admin");*/
		
	 Wait<WebDriver>wait1=new FluentWait<WebDriver>(driver)
			 .withTimeout(Duration.ofSeconds(10))
			 .pollingEvery(Duration.ofSeconds(2))
			 .ignoring(NoSuchElementException.class);
		
		 
		
	
	}

}
