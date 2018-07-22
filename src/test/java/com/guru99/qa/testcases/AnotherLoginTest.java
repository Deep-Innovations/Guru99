package com.guru99.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.testbase.TestBase;
import com.guru99.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AnotherLoginTest extends TestBase {
	LoginPage loginPage;
	TestUtil testUtil;
	ExtentReports extentReports;
	ExtentTest eTest;
	ITestResult results;
	
	public AnotherLoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization("chrome");
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		extentReports = testUtil.setExtentPath();
		
	}
	
	
	@Test
	public void testNowPlease() throws InterruptedException, IOException {
		testUtil.beginExtentLogging("testNowPlease");
		String titleHome = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(titleHome, "Guru 99 hello");
		
	}
	
	@AfterTest
	public void tearItDown() throws IOException, InterruptedException {
		testUtil.afterTest();
		testUtil.ifThenLogStatusMethod(results.getStatus());
		
		
	}
	
	@AfterMethod
	public void weAreNowDone() throws InterruptedException, IOException {
		testUtil.attachScreenshotExtent("yolo");
		testUtil.afterAllTests();
	}

}
