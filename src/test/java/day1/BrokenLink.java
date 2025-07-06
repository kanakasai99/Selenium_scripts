package day1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
public class BrokenLink {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://www.deadlinkcity.com/");
	driver.manage().window().maximize();
	
	
List<WebElement>links=driver.findElements(By.tagName("a"));
System.out.println("total no of links"+links.size());
int brokenLinks=0;
for(WebElement linkElements: links) {
	String hrefValue=linkElements.getAttribute("href");
	if(hrefValue==null || hrefValue.isEmpty()) {
		continue;
	}
	try {
		URL conn=new URL(hrefValue);
		HttpURLConnection openConnect=(HttpURLConnection)conn.openConnection();
		openConnect.connect();
		if(openConnect.getResponseCode()>=400)
		{
			System.out.println(hrefValue+"Broken link");
			
			brokenLinks++;
		}
		else {
			System.out.println(hrefValue+"not Broken link");
		}
	} catch (Exception e) {
		
	}
}
System.out.println("no of broken links"+brokenLinks);
}
}
