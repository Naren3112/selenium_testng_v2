package utilities;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListenersImplementation implements ISuiteListener,ITestListener{
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	BaseActions baseActionsObj = new BaseActions();
	
	@Override
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	@Override
	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		extent = new ExtentReports("TestAutomationReport.html", true);
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		extent.endTest(logger);
		baseActionsObj.driver.quit();
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		extent.endTest(logger);
		baseActionsObj.driver.quit();
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		logger = extent.startTest(arg0.getMethod().getMethodName());
		baseActionsObj.getDriver();
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		extent.endTest(logger);
		baseActionsObj.driver.quit();
	}
	

}
