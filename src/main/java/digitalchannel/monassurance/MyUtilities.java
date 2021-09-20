package digitalchannel.monassurance;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyUtilities {
	
	//public WebDriver driver;
	
	
	/*public MyUtilities(WebDriver driver) {
		this.driver = driver;
	}*/

	public int getUrlResponseCode(String quoterLinkUrl) {
		
		int responseCode = 0;
		
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(quoterLinkUrl).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			responseCode = conn.getResponseCode();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return responseCode;
	}
	
	
	public int findFrames(WebDriver driver, By locator) throws InterruptedException {
		int frameNumber = 0;
		int i = 0;
		List<WebElement> listFrames = driver.findElements(By.tagName("iframe"));
	    for(i=0; i<listFrames.size(); i++) {
	    	
	    	driver.switchTo().frame(i);
	    	
	    	if(driver.findElements(locator).size()>0){
	    		frameNumber = i;
	    		driver.switchTo().defaultContent();
	    		break;
	    		
	    	}
	    	driver.switchTo().defaultContent();
	    }
		return frameNumber;
	}
	
	public String getDownloadFileName(WebDriver driver) {
		
		String mainWindow = driver.getWindowHandle();
		
		JavascriptExecutor mainWindowHandler = (JavascriptExecutor)driver;
		mainWindowHandler.executeScript("window.open()");
		
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		driver.get("chrome://downloads");
		
		JavascriptExecutor downloadWindowHandler = (JavascriptExecutor)driver;
		
		//wait until the file is downloaded
		
		/*Long percentage = (long) 0;
		
		while(percentage != 100) {
			try {
				percentage = (Long) downloadWindowHandler.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#progress').value");
			}catch(Exception e) {
				//Nothing to do just wait
			}
		}*/
		
		//get the latest downloaded file name
		String fileName = (String) downloadWindowHandler.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
		
		
		//close the downloads tab
		driver.close();
		
		//switch back to main window
		driver.switchTo().window(mainWindow);
		
		return fileName;
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
