package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjLoginPage {
	
	public WebDriver driver;
	
	public ObjLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="username")
	private WebElement txtUsername;
	
	@FindBy(id="uapPassword")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	private WebElement btnLogin;
	
	
	public WebElement txtUsername() {
		return txtUsername;
	}
	public WebElement txtPassword() {
		return txtPassword;
	}
	public WebElement btnLogin() {
		return btnLogin;
	}
}
