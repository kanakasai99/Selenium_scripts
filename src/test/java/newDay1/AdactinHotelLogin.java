package newDay1;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AdactinHotelLogin {
	WebDriver driver;
	@Test(priority=1)
void openApp() {
	driver=new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
@Test(priority=2)
void login() {
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("saimereddy");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("LA6S6K");
	
	driver.findElement(By.xpath("//input[@id='login']")).click();
}
@Test(priority=3)
void displayName() {
	boolean status=driver.findElement(By.xpath("//input[@value='Hello saimereddy!']")).isDisplayed();
	Assert.assertEquals(status, true);
}
@Test(priority=4)
void logout() throws InterruptedException {
	driver.findElement(By.xpath("//a[text()='Logout']")).click();
	Thread.sleep(3000);
/*//	boolean stautus=driver.findElement(By.xpath("//td[contains(@text),'You have successfully logged out. ']")).isDisplayed();
	//String stautus=driver.findElement(By.xpath("//td[@class='reg_success']//text()]")).getText();
	//Assert.assertEquals(stautus, true);
	System.out.println("Displayed message is"+ stautus);
	if(stautus.equalsIgnoreCase("You have successfully logged out. ")) {
	
	}
	else {
		System.out.println("Test failed in logging out the adactin website");
	}*/
	String title=driver.getTitle();
	if(title.equalsIgnoreCase("Adactin.com - Logout")) {
		driver.quit();	
	}
	else {
		
		System.out.println("Something went wrong");
	}
}


}
