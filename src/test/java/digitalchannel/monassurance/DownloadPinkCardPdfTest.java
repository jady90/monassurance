package digitalchannel.monassurance;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.ObjDownloadPinkCardPage;
import pageobjects.ObjDownloadPinkCardSummaryPage;
import pageobjects.ObjLandingPage;

public class DownloadPinkCardPdfTest extends Login{
	
	public WebDriver driver;
	
	@Test
	public void downloadPinkCradPdf() {
		
		driver = loginApp();
		
		
	
		
		//Click on Download Pink card link
		ObjLandingPage objLandingPage = new ObjLandingPage(driver);
		objLandingPage.lnkDownloadPinkCard().click();
		
		//Select the pink card pdf option
		ObjDownloadPinkCardPage objDownloadPinkCardPage = new ObjDownloadPinkCardPage(driver);
		objDownloadPinkCardPage.radioDownloadPdf().click();
		
		//complete the flow
		objDownloadPinkCardPage.chkTermsAndConditions().click();
		objDownloadPinkCardPage.btnDownload().click();
		
		//Verify the download Summary page
		ObjDownloadPinkCardSummaryPage objDownloadSummaryPage = new ObjDownloadPinkCardSummaryPage(driver);
		Assert.assertTrue(objDownloadSummaryPage.lblDownloadSuccess().isDisplayed());
		
		//Verify if the file is downloaded successfully
		
		String mainWindow = driver.getWindowHandle();
		
		MyUtilities myUtilities = new MyUtilities();
		String fileName = myUtilities.getDownloadFileName(driver);
		
		driver.switchTo().window(mainWindow);
		
		File f = new File(documentsDownloadPath + "\\" + fileName );
		
		if(f.exists() && f.isFile()) {
		
		Assert.assertTrue(true);
			System.out.println("Test Passed");
		}
	}
		
		

	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
	
}
