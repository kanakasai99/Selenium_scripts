package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		//1)scroll down page by pixel number
		JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1500)");
      System.out.println(js.executeScript("return window.pageYOffset;"));
        
        
       // js.executeScript("window.scrollBy(0,1500)","");
        
        //2) scroll page till end of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println(js.executeScript("return window.pageYOffset;")); //2468
        Thread.sleep(5000);
        
      //3) scroll up to initial position
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        Thread.sleep(5000); 
        
       //4 scroll the page till the element is visible
     
        WebElement cs=driver.findElement(By.xpath("//strong[normalize-space()='Customer service']"));
        js.executeScript("arguments[0].scrollIntoView();", cs);
       System.out.println(js.executeScript("return window.pageYOffset;"));
        
        //js.executeScript("window.scrollBy(0,1500)");
       //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
       //js.executeScript("return window.pageYOffset;"));
      // js.executeScript("arguments[0].scrollIntoView();", cs);
	}
	
	

}
