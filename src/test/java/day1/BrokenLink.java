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
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	
	
List<WebElement>links=driver.findElements(By.tagName("a"));  //Finds all elements with the <a> tag (which represent hyperlinks).
System.out.println("total no of links"+links.size());
int brokenLinks=0;
for(WebElement linkElements: links) {
	String hrefValue=linkElements.getAttribute("href"); // Extracts the href attribute (actual URL) from each <a> tag.
	if(hrefValue==null || hrefValue.isEmpty()) {
		continue;
	}
	try {
		URL conn=new URL(hrefValue);  //	Converts the link string into a URL object.
		HttpURLConnection openConnect=(HttpURLConnection)conn.openConnection(); //Opens a connection to that URL.//Casts it to HTTP so you can work with HTTP-specific info.
		openConnect.connect(); // Tries to connect to the URL (sends the request).
		if(openConnect.getResponseCode()>=400)
		{
			System.out.println(hrefValue+"Broken link");
			
			brokenLinks++;
		}
		else {
			System.out.println(hrefValue+"not Broken link");
		}
	} catch (Exception e) {
		System.out.println(hrefValue + " - Exception: " + e.getMessage());
	}
}
System.out.println("no of broken links"+brokenLinks);
}
}
