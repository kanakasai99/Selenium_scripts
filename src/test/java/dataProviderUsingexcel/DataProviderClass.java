package dataProviderUsingexcel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class DataProviderClass {
	
	
@Test(dataProvider="dp", dataProviderClass=ExcelDataProvider.class)
public void loginTest(String username, String password) throws Exception{
	WebDriver driver=new ChromeDriver();
	try {
	driver.get("https://adactinhotelapp.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	
	driver.findElement(By.xpath("//input[@id='login']")).click();
	boolean isLoggedIn = false;
	try {
	    isLoggedIn = driver.findElement(By.xpath("//input[@value='Hello saimereddy!']")).isDisplayed();
	} catch (Exception e) {
	    // Element not found => login likely failed
	}
	Assert.assertTrue(isLoggedIn, "Login failed for: " + username);

}
	finally{
	driver.quit();
}
}
}

