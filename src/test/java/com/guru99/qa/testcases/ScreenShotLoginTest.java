package com.guru99.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.testbase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ScreenShotLoginTest extends TestBase {
	LoginPage loginPage;
	public ExtentReports extent;
	public ExtentTest extentTest;

	public ScreenShotLoginTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization("chrome");
		loginPage = new LoginPage();
		
	}
	
	@BeforeTest
	public void weWillSetExtent() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/reportForFail/ExtentReport.html", true);
		extent.addSystemInfo("Host", "Jaydeep's MacBook");
		extent.addSystemInfo("Username", "DeepSnaps");
		extent.addSystemInfo("Enviornment", "Automation Testing");
	}
	
	@AfterTest
	public void weWillEndReport() {
		extent.flush();
		extent.close();
	}
	
	public static String getScreenshot(String screenshotID) throws IOException {
		//String fileDate = new SimpleDateFormat("MM/dd/yyyy - hh:mm:ss").format(new Date());
		
		/*
		 * doing mm/dd/yy 
		 * mm/ creates folder for month
		 * dd/ creats folder for day
		 * then the entire file inside that folder is yyyy - hh:mm:ss
		 */
		
		String fileDate = new SimpleDateFormat("MM-dd-yyyy - hh:mm:ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File firstLocation = ts.getScreenshotAs(OutputType.FILE);
		String locationFinal = System.getProperty("user.dir") + "/FailedScreenShotForGuru99/" + screenshotID + fileDate + ".png";
		File finalLocation = new File(locationFinal);
		FileUtils.copyFile(firstLocation, finalLocation);
		return locationFinal;
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case(s) that Passed: " + result.getName());
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case(s) that Skipped: " + result.getName());
		}
		else if (result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test Case(s) that Failed: " + result.getName());
			extentTest.log(LogStatus.FAIL, "Test Case(s) that Failed: " + result.getThrowable());
			
			String screenshotLocation = ScreenShotLoginTest.getScreenshot(result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotLocation));
			
			System.out.println("Had to Capture Screen Shot because test failed!");
		}
		
		extent.endTest(extentTest);
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void captureScreenOnFailure() {
		extentTest = extent.startTest("captureScreenOnFailure");
		String siteTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(siteTitle, "No");
	}
	
}
