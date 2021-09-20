package digitalchannel.monassurance;


import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;


public class LoginTest extends Login{
	
	public WebDriver driver;
	
	@Test
	public void loginTest() {
		
		driver = loginApp();
		
	}
	
	@AfterMethod
	public void teardown() {
	
		closeBrowser();
		
	}
	

}
