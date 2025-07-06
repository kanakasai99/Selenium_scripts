package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	

		public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://ui.vision/demo/webtest/frames/");
			driver.manage().window().maximize();
			WebElement frm3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
			driver.switchTo().frame(frm3);
			WebElement frame3=driver.findElement(By.xpath("//input[@name='mytext3']"));
			frame3.sendKeys("Sai");
			driver.switchTo().frame(0);
			
			WebElement button=driver.findElement(By.xpath("//div[@class='AB7Lab Id5V1']"));
			button.click();
			
			Thread.sleep(5000);
			WebElement checkb=driver.findElement(By.xpath("//div[@class='uHMk6b fsHoPb']"));
			checkb.click();
			//driver.close();
			

}
}