package digitalchannel.monassurance;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class MyListenersFile extends Base implements ITestListener{
	
	WebDriver driver;
	ExtentTest test;
	ExtentReports extent = ReporterNG.getReportObject();
	ThreadLocal<ExtentTest> logger = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		logger.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		logger.get().log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		
		
		
		logger.get().fail(result.getThrowable());
		//logger.get().log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));
		
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		logger.get().addScreenCaptureFromPath(getScreenShotPath(driver, result.getMethod().getMethodName()), result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		logger.get().log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.ORANGE));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
