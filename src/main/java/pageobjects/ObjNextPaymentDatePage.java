package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjNextPaymentDatePage {
	
public WebDriver driver;
	
	public ObjNextPaymentDatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//h1[text()='Change Next Payment Date']")
	private WebElement lblChangeNextPaymentDate;
	
	@FindBy(css="div[class*='bookAppointment']")
	private WebElement btnOpenCalender;
	
	@FindBy(css="tr[role='row'] td")
	private List<WebElement> slctDate;
	
	@FindBy(css="button[class*='btn-primary']")
	private WebElement btnUpdate;
	
	@FindBy(css="[class='alert-title'] strong")
	private WebElement lblChangesSaved;
	
	
	public WebElement lblChangeNextPaymentDate() {
		return lblChangeNextPaymentDate;
	}
	public WebElement btnOpenCalender() {
		return btnOpenCalender;
	}
	public List<WebElement> slctDate() {
		return slctDate;
	}
	public WebElement btnUpdate() {
		return btnUpdate;
	}
	public WebElement lblChangesSaved() {
		return lblChangesSaved;
	}
}
