package day1;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrokenLinkAmazon {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println("total no of links: "+links.size());
	int brokenlinks=0;
	for(WebElement urllinks :links) {
		String orgUrl=urllinks.getAttribute("href");
		if(orgUrl == null || orgUrl.isEmpty()) {
			continue;
		}
		try {
			
			URL url= new URL(orgUrl);
			HttpURLConnection http=(HttpURLConnection)url.openConnection();
			http.connect();
			if(http.getResponseCode()>400) {
				System.out.println(orgUrl+"broken link");
				brokenlinks++;
			}
			else {
				System.out.println("not a broken link"+orgUrl);
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
System.out.println("no of broken links"+brokenlinks);
//driver.close();
}
}
