 

package day1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class BrowserLaunch {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		//ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		
	/*	String status= driver.getTitle();
		
		if(status.equals(status))
		{
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}
		//System.out.println(status);*/
		//Thread.sleep(5000);
		WebElement search=driver.findElement(By.xpath("//input[@id='search']"));
		search.sendKeys("Cocomelon");
		
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		
		
		Thread.sleep(5000);
		
		driver.quit();
		}
}
