package com.guru99.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.guru99.qa.testbase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public  ExtentReports extent;
	public  ExtentTest extentTest;
	public ITestResult result;
	
	
	
	public TestUtil() {
		
	}
	
	
	
	public static void getScreenShot(String fileName) throws IOException {
		// 1. Take Screenshot and store it as a file format.. rmr take screen shot returns file object so create object
		// of the class File...
		File fiLe = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// 2. now copy the screenshot using copyfile method to the desired location
		FileUtils.copyFile(fiLe, new File("/Users/deepsnaps/eclipse-workspace/"
				+ "guru99PracticePOM/src/main/java/com/guru99/qa/pages"+fileName+".png"));
		
	}
	
	public static String getScreenShotForExtent(String nameYourFile) throws IOException {
		String fileDate = new SimpleDateFormat("MM-dd-yyyy - hh:mm:ss").format(new Date());
		TakesScreenshot takeshot = (TakesScreenshot) driver;
		File source = takeshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/GuruScreenShots/" + nameYourFile + fileDate + ".png";
		File finalDestination = new File (destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	
	
/*	public ExtentReports setExtentPath() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/GuruExtentReports/ExtentReport.html", true);
		extent.addSystemInfo("Computer", "DeepSnaps' MacBook");
		extent.addSystemInfo("Enviornment", "Automation Testing");
		return extent;
	}
	*/
	
	
	
	
	/*public ExtentTest beginExtentLogging(String testName) {
		extentTest = extent.startTest(testName);
		return extentTest;
		
	}*/
	
	
	
	
	/*public void loggingIt(LogStatus logStatus, String details) {
		extentTest.log(logStatus, details);
		
	}
	*/
	
	
	/*public void attachScreenshotExtent(String typeItOut) throws IOException {
		String swamiLocation = TestUtil.getScreenShotForExtent(typeItOut);
		extentTest.addScreenCapture(swamiLocation);
		
		//WORKS
	}*/
	
	
	
	/*public void ifThenLogStatusMethod() throws InterruptedException, IOException {
		result = null;
			if (result.getStatus()==ITestResult.FAILURE) {
				extentTest.log(LogStatus.FAIL, "Test Case Failed is: " + result.getName());
				extentTest.log(LogStatus.FAIL, "Test Case Failed is: " + result.getThrowable());
				
				String screenshotPath = TestUtil.getScreenShotForExtent(whatsYourName);
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			}
			else if (result.getStatus()==ITestResult.SKIP) {
				extentTest.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
			}
			else if (result.getStatus()==ITestResult.SUCCESS) {
				extentTest.log(LogStatus.PASS, "Test Case Passed is: " + result.getName());
			}
			
		//DOES NOT WORK
			
	}*/
	
	
	/*public void ifThenLogStatusMethod(int testStatus) throws InterruptedException, IOException {
		testStatus = result.getStatus();
			if (result.getStatus()==ITestResult.FAILURE) {
				extentTest.log(LogStatus.FAIL, "Test Case Failed is: " + result.getName());
				extentTest.log(LogStatus.FAIL, "Test Case Failed is: " + result.getThrowable());
				
				String screenshotPath = TestUtil.getScreenShotForExtent(whatsYourName);
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			}
			else if (result.getStatus()==ITestResult.SKIP) {
				extentTest.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
			}
			else if (result.getStatus()==ITestResult.SUCCESS) {
				extentTest.log(LogStatus.PASS, "Test Case Passed is: " + result.getName());
			}
		//WORKS!
	}*/
	
	
	
	
	/*public void afterTest() {
		extent.flush();
		extent.close();
	}
	
	public void afterAllTests() {
		extent.endTest(extentTest);
		driver.quit();
	}*/
	
	
	
}
