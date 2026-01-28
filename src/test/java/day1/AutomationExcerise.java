package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;

public class AutomationExcerise {
    public static void main(String[] args) {

        // ✅ Get environment variables
        String email = System.getenv("LOGIN_EMAIL");
        String password = System.getenv("LOGIN_PASS");

        // ✅ Check if they are loaded
        if (email == null || password == null) {
            System.out.println("❌ ERROR: Environment variables not found. Please set LOGIN_EMAIL and LOGIN_PASS.");
            return;
        }

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       //WebDriverWait mywait =new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(text(),' Signup / Login')]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait mywait1 =new WebDriverWait(driver,Duration.ofSeconds(10));
        mywait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=' Products']")));
        //driver.findElement(By.xpath("//a[contains(text(),' Products')]")).click();
   driver.findElement(By.xpath("//p[contains(text(),'Sleeveless')]/ancestor::div[@class='single-products']/following-sibling::div/descendant::a")).click();
       driver.findElement(By.xpath("//button[@type='button']")).click();
   //Alert alert=driver.switchTo().alert();
// 
//myalert.click();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Wait for modal and click 'View Cart'
  //WebElement viewCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View Cart")));
  //WebElement  viewCart=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//u[contains(text(),'View Cart')]")));
  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart"))).click();
    //viewCart.click();

   
   driver.close();
    }
}
