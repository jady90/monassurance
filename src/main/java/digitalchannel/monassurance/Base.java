package digitalchannel.monassurance;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;


public class Base {

	public WebDriver driver;
	public Properties prop;
	String documentsDownloadPath = System.getProperty("user.dir") + "\\MyDownloads";
	
	public WebDriver initializeDriver() {
		
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		String browserName = prop.getProperty("browser");
		
		
		if(driver == null) {
		
		if(browserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			
			//Set Chrome Preferences
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", documentsDownloadPath);
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			
			driver = new ChromeDriver(chromeOptions);
		}
		
			else if(browserName.contains("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\msedgedriver.exe");
				driver = new EdgeDriver();
			
		}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		
		return driver;
	}
	
	
	public void closeBrowser() {
		System.out.println("Closing the Browser...");
		driver.close();
		driver = null;
	}
	
	public void teardown() {
		System.out.println("Closing all Browser instances...");
		driver.quit();
		driver = null;
	}
	
	
	
	public String getScreenShotPath(WebDriver driver, String testName) {
		
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		String destFile = System.getProperty("user.dir") + "\\MyScreenshots\\" + testName + timeStamp + ".jpg";
		
		File target = new File(destFile);
		
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destFile;
	
	}
	
}
