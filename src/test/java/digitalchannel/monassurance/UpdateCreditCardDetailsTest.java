package digitalchannel.monassurance;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageobjects.ObjCreditCardDetailsPage;
import pageobjects.ObjLandingPage;
import pageobjects.ObjMyBillingPage;

public class UpdateCreditCardDetailsTest extends Login {
	
	public WebDriver driver;

	@Test
	public void updateCreditcardDetails() throws IOException, InterruptedException {
		
		driver = loginApp();
		
		
		//Navigate to MyBilling page
				ObjLandingPage objLandingPage = new ObjLandingPage(driver);
				objLandingPage.lblMyBilling().click();
				
				//Verify MyBilling Page is displayed
				ObjMyBillingPage objMyBillingPage = new ObjMyBillingPage(driver);
				String pageHeading = objMyBillingPage.lblMyBilling().getText();
				Assert.assertEquals("My Billing", pageHeading);
				
				//Click on Edit Credit Card Details CTA
				objMyBillingPage.btnChangeCreditCardDetails().click();
				
				//Verify Edit payment Info page displayed
				ObjCreditCardDetailsPage objCreditCardDetailsPage = new ObjCreditCardDetailsPage(driver);
				
				Assert.assertTrue(objCreditCardDetailsPage.lblPageHeading().isDisplayed());
				
				//Click on Edit payment details CTA
				objCreditCardDetailsPage.btnEditPaymentDetails().click();
				
				//Verify credit card form page Heading
				
				//Assert.assertTrue(objCreditCardDetailsPage.lblCreditcardFormHeading().isDisplayed());
				
				//Get Excel Data
				String path = ".\\DataFiles\\MyInsurance Data.xlsx";
				XLUtility xlUtils = new XLUtility(path);
				
				String customerName = xlUtils.getCellData("updateCreditCardDetails", 1, 0);
				
				//Enter the credit card details and submit the form
				objCreditCardDetailsPage.txtCustomerName().sendKeys(customerName);
				/*List<WebElement> listFrames = driver.findElements(By.tagName("iframe"));
				System.out.println(listFrames.size());*/
				
				MyUtilities myUti = new MyUtilities();
				int frameNo;
				
				
				
				//int frameNumber = myUtilities.findElementIframe(objCreditCardDetailsPage.txtListCardNumber());
				String creditCardNumber = xlUtils.getCellData("updateCreditCardDetails", 1, 1);
				
				String cardNoLocator = objCreditCardDetailsPage.cardNumberLocator;
				
				frameNo = myUti.findFrames(driver, By.id(cardNoLocator));
				driver.switchTo().frame(frameNo);
				driver.findElement(By.id(cardNoLocator)).sendKeys(creditCardNumber);
				
				/*for(int i=0; i<listFrames.size(); i++) {
					driver.switchTo().frame(i);
					//Thread.sleep(3000);
					if(driver.findElements(By.id("bambora-card-number")).size() > 0) {
						//driver.findElement(By.id("bambora-card-number")).click();
						driver.findElement(By.id("bambora-card-number")).sendKeys("4030000010001234");
						driver.switchTo().defaultContent();
						break;
					}
				
					driver.switchTo().defaultContent();
				}*/
				
				//bambora-expiry
				//driver.switchTo().frame(0);
				//objCreditCardDetailsPage.txtCardNumber().sendKeys("4030000010001234");
				
				//driver.switchTo().defaultContent();
				
				//frameNumber = myUtilities.findElementIframe(objCreditCardDetailsPage.txtListExpiryNumber());
                //driver.switchTo().frame(0);
				driver.switchTo().defaultContent();
				//Thread.sleep(3000);
				
				String creditCardExpiry = xlUtils.getCellData("updateCreditCardDetails", 1, 2);
				frameNo = myUti.findFrames(driver, By.id("bambora-expiry"));
				driver.switchTo().frame(frameNo);
				driver.findElement(By.id("bambora-expiry")).sendKeys(creditCardExpiry);
				
				/*for(int i=0; i<listFrames.size(); i++) {
					driver.switchTo().frame(i);
					//Thread.sleep(3000);
					if(driver.findElements(By.id("bambora-expiry")).size() > 0) {
						//driver.findElement(By.id("bambora-expiry")).click();
						driver.findElement(By.id("bambora-expiry")).sendKeys("0523");
						driver.switchTo().defaultContent();
						break;
					}
				
					driver.switchTo().defaultContent();
				}*/
                //objCreditCardDetailsPage.txtExpiryNumber().sendKeys("0523");
				
				//driver.switchTo().defaultContent();
				//bambora-cvv
				driver.switchTo().defaultContent();
				
				Thread.sleep(3000);
				
				String creditCardCVV = xlUtils.getCellData("updateCreditCardDetails", 1, 3);
				frameNo = myUti.findFrames(driver, By.id("bambora-cvv"));
				driver.switchTo().frame(frameNo);
				driver.findElement(By.id("bambora-cvv")).sendKeys(creditCardCVV);
				
/*		for (int i = 0; i < listFrames.size(); i++) {
			driver.switchTo().frame(i);
			// Thread.sleep(3000);
			if (driver.findElements(By.id("bambora-cvv")).size() > 0) {
				// driver.findElement(By.id("bambora-cvv")).click();
				driver.findElement(By.id("bambora-cvv")).sendKeys("123");
				driver.switchTo().defaultContent();
				break;
			}

			driver.switchTo().defaultContent();
		}*/
				
				driver.switchTo().defaultContent();
				//objCreditCardDetailsPage.txtCvv().sendKeys(prop.getProperty("cvv"));
				
				objCreditCardDetailsPage.chkTermsAndConditions().click();
				objCreditCardDetailsPage.btnUpdate().click();
				
				//Verify if the update is successful
				//Thread.sleep(3000);
				Assert.assertTrue(objCreditCardDetailsPage.lblChangesSaved().isDisplayed());
				
	}
	
	/*public int findFrames(WebDriver driver1, By locator) throws InterruptedException {
		int frameNumber = 0;
		int i = 0;
		List<WebElement> listFrames = driver1.findElements(By.tagName("iframe"));
	    for(i=0; i<listFrames.size(); i++) {
	    	Thread.sleep(3000);
	    	driver1.switchTo().frame(i);
	    	Thread.sleep(3000);
	    	if(driver1.findElements(locator).size()>0){
	    		frameNumber = i;
	    		break;
	    		
	    	}
	    	
	    }
		return frameNumber;
	}*/
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
	
}
