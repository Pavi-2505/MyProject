package com.crm.Vtiger.genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * right click->source->add unm
 */
public class ListnerImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
	//	test.log(Status.FAIL, result.getThrowable());
		
		String screenshot = WebdriverUtility.getTheScreenShotOfThePage(Baseclass.sdriver, result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(screenshot);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
	//	test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Extent Report");
		spark.config().setReportName("Pavithra");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows11");
		report.setSystemInfo("Exetedby", "pavithra");
		report.setSystemInfo("reviewedBy", "Sanjay");	
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}	
}
