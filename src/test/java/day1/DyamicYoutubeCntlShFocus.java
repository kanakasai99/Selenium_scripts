package day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DyamicYoutubeCntlShFocus {
	   public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    
    driver.manage().window().maximize();

    driver.get("https://www.youtube.com/");
    WebElement searchbox = driver.findElement(By.xpath("//input[@name='search_query']"));
    searchbox.sendKeys("redmi");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'ytSuggestionComponentSuggestion')]")));
    
    List<WebElement> suggestions=driver.findElements((By.xpath("//div[contains(@class,'ytSuggestionComponentSuggestion')]")));
    for(WebElement w: suggestions) {
    	System.out.println(w.getText());
    	if(w.getText().equalsIgnoreCase("redmi note 13 5g")) {
    		w.click();
    	}
    }
    
}
}
