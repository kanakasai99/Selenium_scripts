package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {
	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions act=new Actions(driver);
		act.contextClick(button).perform();
		//(//li[@class='context-menu-item context-menu-icon context-menu-icon-copy context-menu-hover context-menu-visible'])[1]
		//driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy context-menu-hover context-menu-visible'])[1]"));     
		//driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		driver.findElement(By.xpath("//span[text()='Cut']")).click();
		Thread.sleep(5000);
	driver.switchTo().alert().accept();
	
	
	}
	

}
