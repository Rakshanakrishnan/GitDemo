package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Components.HomePage;

public class Listener extends HomePage implements ITestListener {
	ExtentTest test;
	ExtentReports extent= ExtentReport.ReportObject();
	ThreadLocal<ExtentTest> threadTest= new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		threadTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		threadTest.get().log(Status.PASS, "Test Passed!");

	}

	public void onTestFailure(ITestResult result) {
		threadTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String MethodName=result.getMethod().getMethodName();

		try { driver =
				(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").
				get(result.getInstance()); }
		catch (Exception e1) { // TODO Auto-generated
			e1.printStackTrace();

		}

		try {
			threadTest.get().addScreenCaptureFromPath(getScreenshot(MethodName, driver), result.getMethod().getMethodName());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}


}
