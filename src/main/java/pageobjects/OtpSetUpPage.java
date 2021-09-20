package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtpSetUpPage {

public WebDriver driver;
	
	public OtpSetUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="div[class='cdk-global-overlay-wrapper'] div:nth-child(2) div:nth-child(1) button:nth-child(1)")
	private WebElement btnTextMe;
	
	@FindBy(css="div[class='cdk-global-overlay-wrapper'] div:nth-child(2) div:nth-child(1) button:nth-child(1)")
	private List<WebElement> listOfBtnTextMe;
	
	@FindBy(id="code")
	private WebElement txtSecurityCode;
	
	@FindBy(xpath="//button[@translate='BUTTON.ENTER']")
	private WebElement btnEnter;
	
	
	public WebElement btnTextMe() {
		return btnTextMe;
	}
	public WebElement txtSecurityCode() {
		return txtSecurityCode;
	}
	public WebElement btnEnter() {
		return btnEnter;
	}
	public List<WebElement> listOfBtnTextMe() {
		return listOfBtnTextMe;
	}
	
}
