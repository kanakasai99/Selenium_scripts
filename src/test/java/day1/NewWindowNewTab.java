package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowNewTab {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/");
		
		//Selenium4.x
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://orangehrm.com/");
	}

	}


