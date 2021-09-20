package digitalchannel.monassurance;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import pageobjects.ObjLandingPage;
import pageobjects.ObjMyBillingPage;
import pageobjects.ObjNextPaymentDatePage;


public class EditNextPaymentDateTest extends Login{

	public WebDriver driver;
	
	
	@Test
	public void editNextPaymentDate() {
		
		driver = loginApp();
		
		
		
		//Navigate to MyBilling page
		ObjLandingPage objLandingPage = new ObjLandingPage(driver);
		objLandingPage.lblMyBilling().click();
		
		//Verify MyBilling Page is displayed
		ObjMyBillingPage objMyBillingPage = new ObjMyBillingPage(driver);
		String pageHeading = objMyBillingPage.lblMyBilling().getText();
		Assert.assertEquals("My Billing", pageHeading);
		
		//Click Edit Payment Date CTA
		objMyBillingPage.btnEditPaymentDate().click();
			
		//Verify Change Payment Date page is displayed
		Assert.assertTrue(objMyBillingPage.lblChangePaymentDate().isDisplayed());
		
		//Click on Next Payment date CTA
		ObjNextPaymentDatePage objNextPaymentDate = objMyBillingPage.btnNextPaymentDate();
		
		//Verify Next Payment Change Page is displayed
		Assert.assertTrue(objNextPaymentDate.lblChangeNextPaymentDate().isDisplayed());
		
		//Change the Next payment Date
		objNextPaymentDate.btnOpenCalender().click();
		
		int size = objNextPaymentDate.slctDate().size();
		
		for(int i=1; i<size; i++) {
			String d = objNextPaymentDate.slctDate().get(i).getText();
			if(d.equalsIgnoreCase("27")) {
				objNextPaymentDate.slctDate().get(i).click();
				break;
			}
		}
		
		
		objNextPaymentDate.btnUpdate().click();
		
		//Verify if the update is successful
		Assert.assertTrue(objNextPaymentDate.lblChangesSaved().isDisplayed());
		
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		String expTitle = "Maison Curry";
		//Assert.assertEquals(actTitle, expTitle);
		if(actTitle.equalsIgnoreCase(expTitle)) {
			System.out.println("Test Case Passed");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Test Case Failed");
			Assert.assertTrue(false);
		}
		
	}
	
	
	
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}
