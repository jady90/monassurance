package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjDownloadPinkCardSummaryPage {
	
public WebDriver driver;
	
	public ObjDownloadPinkCardSummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//p[text()='Your pink card has been downloaded.']")
	private WebElement lblDownloadSuccess;
	
	
	
	
	public WebElement lblDownloadSuccess() {
		return lblDownloadSuccess;
	}

}
