package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FlipcartDropdownSelect {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open Flipkart
        driver.get("https://www.flipkart.com/");

        // Directly click using link text (only works if element is in DOM without hover)
        driver.findElement(By.linkText("Men's Formal Shoes")).click();

        // OR directly open the URL without clicking menu
        // driver.get("https://www.flipkart.com/mens-footwear/formal-shoes/pr?sid=osp%2Ccil%2Cssb");

        driver.quit();
    }
}
