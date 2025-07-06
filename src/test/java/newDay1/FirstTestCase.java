package newDay1;

import org.testng.annotations.Test;

public class FirstTestCase {

@Test(priority=1)
void openApp() {
	System.out.println("1. open app is running");
}

@Test(priority=2)
void login() {
	System.out.println("2. login method is running");
	
}
@Test(priority=-1)
void logout() {
	System.out.println("3. logout is running");
}
}
