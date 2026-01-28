package day1;
import java.time.Duration;
import java.util.*;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();

            driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement dropdown =driver.findElement(By.xpath("//select[@id='country']"));
        js.executeScript("arguments[0].scrollIntoView()",dropdown);
        dropdown.click();
        List<WebElement> options=driver.findElements(By.xpath("//select[@id='country']/option"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (WebElement option : options) {
            String country = option.getText().trim();

            if (country.equals("India")) {
                wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                System.out.println("Selected country : " + country);
                break;
            }
        }



        //  driver.close();
    }
}
