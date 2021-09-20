package digitalchannel.monassurance;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReporterNG {
	
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report" + timeStamp + ".html";
		String reportPath = System.getProperty("user.dir") + "\\MyReports\\" + reportName;
		
		sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setDocumentTitle("MyInsurance Test Project");
		sparkReporter.config().setReportName("MyInsurance Test Automation Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Jagdeep Singh");
		
		return extent;
	}

}
