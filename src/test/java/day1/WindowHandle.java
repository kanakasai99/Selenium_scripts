package day1;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class WindowHandle {
public static void main(String[] args) throws Exception {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.orangehrm.com/");
	driver.manage().window().maximize();
	String parent=driver.getWindowHandle();
	System.out.println(parent);
	
	Actions action=new Actions(driver);
	WebElement about=driver.findElement(By.xpath("//a[contains(text(),'E-Books')]"));
	action.moveToElement(about).click().perform();
	
	Set<String> windows=driver.getWindowHandles();
	List<String> windowList=new ArrayList<>(windows);
	
	for(String windoww : windowList) {
		if(!windoww.equals(parent)){
			System.out.println("we are closing this window handle: "+windoww);
	driver.switchTo().window(windoww);
	Thread.sleep(5000);
	driver.close();
	}
	}
	
}
}
