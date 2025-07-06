package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys("tablets");
		//driver.findElement(By.xpath("//a[text()='iPhone']")).click();
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys("mobiles");
		driver.findElement(By.xpath("//input[starts-with(@type,'search')]")).sendKeys("android");
//driver.close();
	}

}
