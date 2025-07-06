package day1;
import java.time.Duration;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
public class NewScreenshot {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.barnesandnoble.com/");
	driver.manage().window().maximize();
	
	TakesScreenshot tr=(TakesScreenshot)driver;
	File scFl=tr.getScreenshotAs(OutputType.FILE);
	File trFl=new File(System.getProperty("user.dir")+"\\Screenshot\\newpage.png");
	scFl.renameTo(trFl);// copy source file to target file, since we don't kow the location of source file wherever it is gonna copied to our target file
}
}
