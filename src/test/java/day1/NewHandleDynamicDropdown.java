package day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewHandleDynamicDropdown {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.flipkart.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("iqoo");

        // Wait until suggestions appear
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//li[contains(@class,'_3D0G9a')]")));

        List<WebElement> suggestions = driver.findElements(By.xpath("//li[contains(@class,'_3D0G9a')]"));

        System.out.println("Suggestions found: " + suggestions.size());
        for (WebElement element : suggestions) {
            System.out.println(element.getText());
        }

        // Example: click a specific suggestion (if matches "iqoo z7")
        for (WebElement element : suggestions) {
            if (element.getText().toLowerCase().contains("iqoo z7")) {
                element.click();
                break;
            }
        }

        driver.quit();
    }
}
