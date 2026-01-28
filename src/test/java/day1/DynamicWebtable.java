package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicWebtable {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[ contains(text(),'Dynamic Web Table')]")));
        js.executeScript("arguments[0].scrollIntoView();",ele);
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='taskTable']/descendant::tr"));

         System.out.println("no of rows in that dynamic table: "+rows.size());
//1. First I will fetch all the rows from the dynamic table.


for(int r=1;r<rows.size();r++){
    WebElement names=driver.findElement(By.xpath("//table[@id='taskTable']/descendant::tbody/tr["+r+"]/td[1]"));
    System.out.println(names.getText());
    if(names.getText().equals("Chrome")){
         String cpuLoad=driver.findElement(By.xpath("//tbody[@id='rows']/tr/td[contains(text(),'Chrome')]/following-sibling::td[contains(text(),'MB/s')]")).getText();
        System.out.println("The cpu load of chrome is : "+cpuLoad);
        break;
    }
}
//
driver.quit();
    }
}
