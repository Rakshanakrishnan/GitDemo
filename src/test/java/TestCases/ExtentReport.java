package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReport {
	 static ExtentReports extent;
		public static ExtentReports ReportObject() {
			String path= System.getProperty("user.dir") + "\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Automation Result");
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester","Rakshu");
			return extent;
		}
}
