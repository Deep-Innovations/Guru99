package com.guru99.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru99.qa.pages.HomePage;
import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.testbase.TestBase;
import com.guru99.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	
	public LoginPageTest() {
		super();
	}
	
	 private static final Logger log = LogManager.getLogger(LoginPageTest.class.getName());
	//private static final Logger log = LogManager.getLogger("LoginPage");
	 
	 
	
	@BeforeMethod
	
	public void setUp() {
		initialization("ff");
		loginPage = new LoginPage();
	}
	
	@BeforeTest 
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Computer Name: ", "DeepSnap's MacBook Pro");
		extent.addSystemInfo("Host Name", "OSX");
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("MM-dd-yyyy-hh:dd:ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	@Test(enabled=false)
	public void loginPageTitleVerificationTest() {
		log.info("*************First Test*************************");
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page");
		log.info("*************End of First Test*************************");
		
			
		try {
			Assert.assertEquals(title, "Guru909 Bank Home Page");
			log.info("YAY");
		} catch(AssertionError e) {
			log.error(e);
			String hello = log.getName();
			System.out.println(hello);
			
			
		}
			
	}
	
	@Test(enabled=false)
	public void testf() throws InterruptedException {
		log.info("*************Second Test*************************");
		loginPage.letsLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		String titleOfPage = driver.getTitle();
		Assert.assertEquals(titleOfPage, "Guru99 Bank Manager HomePage");
		log.info("*************End Test*************************");
		
	}	
	
	@Test(enabled=false)
	public void testShot() throws IOException {
		log.info("About to take a screenshot");
		TestUtil.getScreenShot("testingGetScreenShotMethod");
		log.info("After taking screenshot");
	}
	
	@Test(priority=1)
	public void takeScreenShotTest() {
		extentTest = extent.startTest("takeScreenShotTest");
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Guru9009 Bank Home Page");
		
	}
	
		
	
	@AfterMethod
	public void firstClose(ITestResult result) throws InterruptedException, IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test Case Failed is: " + result.getName());
			extentTest.log(LogStatus.FAIL, "Test Case Failed is: " + result.getThrowable());
			
			String screenshotPath = LoginPageTest.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case Skipped is: " + result.getName());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case Passed is: " + result.getName());
		}
		
		extent.endTest(extentTest);
		driver.close();
		
	}
}
