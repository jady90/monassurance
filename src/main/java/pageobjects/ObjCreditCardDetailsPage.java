package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjCreditCardDetailsPage {

public WebDriver driver;
	
	public ObjCreditCardDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="div[class*='page__heading']")
	private WebElement lblPageHeading;
	
	@FindBy(css="button[class*='btn-primary']")
	private WebElement btnEditPaymentDetails;
	
	@FindBy(xpath="//h1[text()='Edit Credit Card Information']")
	private WebElement lblCreditcardFormHeading;
	
	@FindBy(id="creditCardHolder")
	private WebElement txtCustomerName;
	
	@FindBy(id="bambora-card-number")
	public WebElement txtCardNumber;
	
	public String cardNumberLocator = "bambora-card-number";
	
	@FindBy(id="bambora-card-number")
	public List<WebElement> txtListCardNumber;
	
	
	
	@FindBy(id="bambora-expiry")
	public WebElement txtExpiryNumber;
	
	@FindBy(id="bambora-expiry")
	public List<WebElement> txtListExpiryNumber;
	
	
	@FindBy(id="bambora-cvv")
	public WebElement txtCvv;
	
	@FindBy(id="termsAndConditions")
	public WebElement chkTermsAndConditions;
	
	@FindBy(css="button[class*='btn-primary']")
	private WebElement btnUpdate;
	
	@FindBy(css="[class='alert-title'] strong")
	private WebElement lblChangesSaved;
	
	
	
	
	public WebElement lblPageHeading() {
		return lblPageHeading;
	}
	
	public WebElement btnEditPaymentDetails() {
		return btnEditPaymentDetails;
	}
	
	public WebElement lblCreditcardFormHeading() {
		return lblCreditcardFormHeading;
	}
	
	public WebElement txtCustomerName() {
		return txtCustomerName;
	}
	
	public WebElement txtCardNumber() {
		return txtCardNumber;
	}
	
	public List<WebElement> txtListCardNumber() {
		return txtListCardNumber;
	}
	
	
	public WebElement txtExpiryNumber() {
		return txtExpiryNumber;
	}
	
	public List<WebElement> txtListExpiryNumber() {
		return txtListExpiryNumber;
	}
	
	
	public WebElement txtCvv() {
		return txtCvv;
	}
	
	public WebElement chkTermsAndConditions() {
		return chkTermsAndConditions;
	}
	
	public WebElement btnUpdate() {
		return btnUpdate;
	}
	
	public WebElement lblChangesSaved() {
		return lblChangesSaved;
	}
}
