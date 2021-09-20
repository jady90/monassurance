package digitalchannel.monassurance;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.ObjLandingPage;

public class VerifyQuoterLinksTest extends Login{
	
	
	public WebDriver driver;
	
	
	
	
	@Test
	public void verifyQuoterLinks() {
		
		driver = loginApp();
		
		
		//Click on Get a Quoter pop up
		ObjLandingPage objLandingPage = new ObjLandingPage(driver);
		objLandingPage.lnkGetAQuote().click();
		
		//Verify pop is displayed
		Assert.assertTrue(objLandingPage.dlgQuoterLinkPopUp().isDisplayed());
		
		//Get all the Quoter links
		List<WebElement> listQuoterLinks = objLandingPage.dlgQuoterLinkPopUp().findElements(By.tagName("a"));
		
		//Soft Assert
		SoftAssert softAssert = new SoftAssert();
		
		for(WebElement quoterLink : listQuoterLinks) {
			
			String quoterLinkUrl = quoterLink.getAttribute("href");
			
			//Get Response code of the Url
			MyUtilities myUtilities = new MyUtilities();
			int responseCode = myUtilities.getUrlResponseCode(quoterLinkUrl);
			
			
			softAssert.assertTrue(responseCode<400, "The link with name " + quoterLink.getText() + " is broken with error code: " + responseCode);
			
		}
		
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
	

}






















