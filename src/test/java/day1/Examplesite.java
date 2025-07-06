package day1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Examplesite {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver= new ChromeDriver();
		driver.get("https://automationteststore.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//input[@type='text']
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Fragrance");
		//i[@class='fa fa-search']
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		////*[@id="maincontainer"]/div/div/div/div/div[3]/div[1]/div[2]/a/img
		//<img src="//automationteststore.com/image/thumbnails/18/70/demo_product28_1_jpg-100108-250x250.jpg" width="250" height="250" alt="">
		Actions ac=new Actions(driver);
		WebElement product=driver.findElement(By.xpath("//i[@class='fa fa-cart-plus fa-fw']"));
		ac.moveToElement(product).click().perform();
		WebElement cart=driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart fa-fw']"));
		ac.moveToElement(cart).click().perform();
		Thread.sleep(5000);
		//a[@id='cart_checkout1']
	WebElement checkout=	driver.findElement(By.xpath("//a[@id='cart_checkout1']"));
	ac.moveToElement(checkout).click().perform();
//	Thread.sleep(5000);
	//input[@id='accountFrm_accountguest']
	
	WebElement guestButton=driver.findElement(By.xpath("//input[@id='accountFrm_accountguest']"));
	guestButton.click();
	//button[@title='Continue']
	WebElement submit=driver.findElement(By.xpath("//button[@title='Continue']"));
	ac.moveToElement(submit).click().perform();
	//input[@name='firstname']
	WebElement first=driver.findElement(By.xpath("//input[@name='firstname']"));
	ac.scrollToElement(first);
	first.sendKeys("kanaka");
	//input[@name='lastname']
	 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sai");
	//input[@name='email']
	 driver.findElement(By.xpath("//input[@name='email']")).sendKeys("xyz@gmail.com");
	//input[@name='address_1']
	 driver.findElement(By.xpath("//input[@name='address_1']")).sendKeys("Miyapur");
	//input[@name='city']
	 driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bezawada");
	 
	 WebElement state=driver.findElement(By.xpath("//select[@name='zone_id']"));
	 Select stateList=new Select(state);
	List<WebElement>options= stateList.getOptions();
	for(WebElement op:options) {
		System.out.println(op.getText());
	}
	 stateList.selectByIndex(2);
	 
	//input[@name='postcode']
	 driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("1003");
	 
	WebElement coutylist= driver.findElement(By.xpath("//select[@id='guestFrm_country_id']"));
	 Select country= new Select(coutylist);
	 country.selectByIndex(2);
	 //Thread.sleep(5000);
	 
	 
	 
	//button[@type='submit']
	 WebElement complete=driver.findElement(By.xpath("//button[@type='submit']"));
	 ac.moveToElement(complete).click().perform();
	 

	 
	 
	driver.close();
	}

}
