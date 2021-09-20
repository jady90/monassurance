package digitalchannel.monassurance;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageobjects.ObjLandingPage;
import pageobjects.ObjLoginPage;
import pageobjects.OtpSetUpPage;

public class Login extends Base{
	
	public WebDriver driver;
	private int size;
	
	

	public WebDriver loginApp(){
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("baseUrl"));
		
		ObjLoginPage objLoginPage = new ObjLoginPage(driver);
		
		//Enter Username and Password
		objLoginPage.txtUsername().sendKeys(prop.getProperty("username"));
		objLoginPage.txtPassword().sendKeys(prop.getProperty("password"));
		
		objLoginPage.btnLogin().click();
		
		//check if otp is asked to enter on login
		OtpSetUpPage otpSetUpPage = new OtpSetUpPage(driver);
		size= otpSetUpPage.listOfBtnTextMe().size();
		
		if(size > 0) {
			otpSetUpPage.btnTextMe().click();
			otpSetUpPage.txtSecurityCode().sendKeys(prop.getProperty("otpCode"));
			otpSetUpPage.btnEnter().click();
		}
		
		//Verify if login is successful
        ObjLandingPage objLandingPage = new ObjLandingPage(driver);
		if(objLandingPage.lblMyPolicies().isDisplayed()) {
			System.out.println("Login Successful");
		}
		return driver;
	}
}
