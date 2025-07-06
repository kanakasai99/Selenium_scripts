package day1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class BarnesAndNoble {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://automationteststore.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//input[@type='text']
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Fragrance");
		//i[@class='fa fa-search']
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		////*[@id="maincontainer"]/div/div/div/div/div[3]/div[1]/div[2]/a/img
		//<img src="//automationteststore.com/image/thumbnails/18/70/demo_product28_1_jpg-100108-250x250.jpg" width="250" height="250" alt="">
		Actions ac=new Actions(driver);
		WebElement product=driver.findElement(By.xpath("//i[@class='fa fa-cart-plus fa-fw']"));
		ac.moveToElement(product).click().perform();
		WebElement cart=driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart fa-fw']"));
		ac.moveToElement(cart).click().perform();
		
	}

}
