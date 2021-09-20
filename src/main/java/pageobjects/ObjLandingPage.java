package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjLandingPage {

public WebDriver driver;
	
	public ObjLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="div[class='top-section__menu']")
	private WebElement lblMyPolicies;
	
	@FindBy(css="a[href*='/billing']")
	private WebElement lblMyBilling;
	
	@FindBy(xpath="//span[@class='margin-right-5']")
	private WebElement lnkDownloadPinkCard;
	
	@FindBy(css="button[modaltitle*='get_a_quote']")
	private WebElement lnkGetAQuote;
	
	@FindBy(css="div[class*=modal-content]")
	private WebElement dlgQuoterLinkPopUp;
	
	
	public WebElement lblMyPolicies() {
		return lblMyPolicies;
	}
	public WebElement lblMyBilling() {
		return lblMyBilling;
	}
	public WebElement lnkDownloadPinkCard() {
		return lnkDownloadPinkCard;
	}
	public WebElement lnkGetAQuote() {
		return lnkGetAQuote;
	}
	public WebElement dlgQuoterLinkPopUp() {
		return dlgQuoterLinkPopUp;
	}
	
}
