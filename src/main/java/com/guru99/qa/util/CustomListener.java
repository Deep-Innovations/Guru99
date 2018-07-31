package com.guru99.qa.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListener implements ITestListener {
	public ExtentReports report;
	public ExtentTest test;

	
	

	public void onTestStart(ITestResult result) {
		// only executes on the start of the test methods, "@Test". Not any of the @Before tags.
		test = report.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + " Test has been started");
		
	}

	public void onTestSuccess(ITestResult result) {
		// Runs if @Test is successful
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + " Test has Passed");
		
		
	}

	public void onTestFailure(ITestResult result) {
		// Runs if @Test fails
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Test has Failed");
		try {
			String path = TestUtil.getScreenShotForExtent(result.getMethod().getMethodName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Test has failed" + imagePath);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Test has failed" + result.getThrowable());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// Runs if @Test is skipped
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " Test has skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// starts before the <test> tag of the xml file!
		// how to print all of the test methods inside of that <test> tag?
		/*
		 * ITestNGMethod methods = context.getAllTestMethods
		 * for (ITestNGMethod method : methods) {
		 * 	 	System.out.println(method.getMethodName());
		 * }
		 */
		
		report = new ExtentReports(System.getProperty("user.dir") + "/GuruExtentReports/ExtentReports.html", false);
		report.addSystemInfo("Computer", "DeepSnap's MBP");
		report.addSystemInfo("Enviornment", "Automation");
	}

	public void onFinish(ITestContext context) {
		// starts after the <test> tag of the xml file!
		report.flush();
		
		
		
	}

}
