package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjMyBillingPage {
	
public WebDriver driver;
	
	public ObjMyBillingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="div[class='page__heading'] h1")
	private WebElement lblMyBilling;
	
	@FindBy(xpath="//div[text()='Auto']")
	private WebElement tabAuto;
	
	@FindBy(css="a[href*=modifyPaymentDate]")
	private WebElement btnEditPaymentDate;
	
	@FindBy(css="a[href*='/nextPayment']")
	private WebElement btnNextPaymentDate;
	
	@FindBy(css="a[href*='/allDates']")
	private WebElement btnAllFuturePaymentDates;
	
	@FindBy(css="div[class='page__heading'] h1")
	private WebElement lblChangePaymentDate;
	
	@FindBy(css="a[href*='/changeToCc']")
	private WebElement btnEnrollToCreditPayment;
	
	@FindBy(css="a[href*='/updateCc']")
	private WebElement btnChangeCreditCardDetails;
	
	
	public WebElement lblMyBilling() {
		return lblMyBilling;
	}
	public WebElement tabAuto() {
		return tabAuto;
	}
	
	public WebElement btnEditPaymentDate() {
		return btnEditPaymentDate;
	}
	public ObjNextPaymentDatePage btnNextPaymentDate() {
		btnNextPaymentDate.click();
		return new ObjNextPaymentDatePage(driver);
	}
	public WebElement btnAllFuturePaymentDates() {
		return btnAllFuturePaymentDates;
	}
	public WebElement lblChangePaymentDate() {
		return lblChangePaymentDate;
	}
	public WebElement btnEnrollToCreditPayment() {
		return btnEnrollToCreditPayment;
	}
	public WebElement btnChangeCreditCardDetails() {
		return btnChangeCreditCardDetails;
	}

}
