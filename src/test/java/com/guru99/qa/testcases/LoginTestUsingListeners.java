package com.guru99.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.pages.HomePage;
import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.testbase.TestBase;


public class LoginTestUsingListeners extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginTestUsingListeners() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization("ff");
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void titleTest() {
		String homeTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(homeTitle, "Guru is so cool");
	}
	@Test(priority=2)
	public void loginTest() {
		loginPage.letsLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
