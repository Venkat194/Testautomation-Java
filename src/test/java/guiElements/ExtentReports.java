package guiElements;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports implements ITestListener 
{

	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test; 
	
	 public void onStart(ITestContext context) 
	 {
		 sparkreporter =new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreports.html");
		 sparkreporter.config().setDocumentTitle("TestAutomaionPractice_Report");
		 sparkreporter.config().setReportName("Automationtesting");
		 sparkreporter.config().setTheme(Theme.DARK);
		 
		 extent = new ExtentReports();
		 
	 }
	
	public void onTestStart(ITestResult result) {
	   
	  }
	
}
