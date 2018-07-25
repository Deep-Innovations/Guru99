package com.guru99.qa.testcases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.qa.pages.AddNewCustomer;
import com.guru99.qa.pages.HomePage;
import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.testbase.TestBase;
import com.guru99.qa.util.TestUtil;

public class AddNewCustoTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	AddNewCustomer anCusto;
	
	public AddNewCustoTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization("chrome");
		loginPage = new LoginPage();
		homePage = new HomePage();
		anCusto = new AddNewCustomer();
	}
	
	
	@Test(enabled=false)
	public void hpTitleVisibility() throws FileNotFoundException, IOException {
		loginPage.letsLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage.homePageTitleVisible();
		homePage.verifyMovingGuru();
	}
	@Test(priority=1)
	public void enterNewCustoInfo() throws InterruptedException, IOException {
		loginPage.letsLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickNewCustomer();
		String addCustoPageTitle = driver.getTitle();
		Assert.assertEquals(addCustoPageTitle, "Guru99 Bank New Customer Entry Page");
		anCusto.addNewCustomerInfo();
		anCusto.getCustoID();
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
}
