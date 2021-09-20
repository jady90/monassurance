package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ObjDownloadPinkCardPage {
public WebDriver driver;
	
	public ObjDownloadPinkCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1[text()='Download Pink Card']")
	private WebElement lblPageHeading;
	
	@FindBy(css="input[value='PDF']")
	private WebElement radioDownloadPdf;
	
	@FindBy(css="input[value='PKPass']")
	private WebElement radioDownloadPkPass;
	
	@FindBy(css="input[id*=acceptedTerms]")
	private WebElement chkTermsAndConditions;
	
	@FindBy(css="button[type='submit']")
	private WebElement btnDownload;
	
	
	
	
	//Methods
	public WebElement lblPageHeading() {
		return lblPageHeading;
	}
	
	public WebElement radioDownloadPdf() {
		return radioDownloadPdf;
	}
	public WebElement radioDownloaadPkPass() {
		return radioDownloadPkPass;
	}
	public WebElement chkTermsAndConditions() {
		return chkTermsAndConditions;
	}
	public WebElement btnDownload() {
		return btnDownload;
	}
}
