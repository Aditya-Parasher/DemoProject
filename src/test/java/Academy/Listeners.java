package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReport;

public class Listeners extends Base implements ITestListener{
	
	static ExtentTest test;
	static ExtentReports extent=ExtentReport.getReport();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();//this is used for parellel execution such that it wont override methods on execution
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName()); //initial step to associate the test cases with reports
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test cases are passed !!!"); //to declare a pass in the reports
		//extentTest.get() method is part of threadLocal and is used to avoid overriding
	}

	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable()); //this will record all failures
		
		String TestMethodName=result.getMethod().getMethodName(); //to get the name of the method to have a SS
		WebDriver driver=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance()); //for calling all the drivers from different classes-its common step
		} catch (Exception e)
		{
			
		}	
		
		try {
			extentTest.get().addScreenCaptureFromPath(Screenshots(TestMethodName,driver),result.getMethod().getMethodName());
			
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

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
