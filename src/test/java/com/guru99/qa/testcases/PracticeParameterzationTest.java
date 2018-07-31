package com.guru99.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.qa.pages.AddNewCustomer;
import com.guru99.qa.pages.HomePage;
import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.testbase.TestBase;
import com.guru99.qa.util.TestUtil;

public class PracticeParameterzationTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	AddNewCustomer anCusto;
	String sheetName = "newCustomers";
	
	public PracticeParameterzationTest() {
		super();
	}
	
	//@BeforeMethod
	public void setUp() {
		initialization("ff");
		loginPage = new LoginPage();
		homePage = new HomePage();
		anCusto = new AddNewCustomer();
	}
	
	@DataProvider(name="practiceMethod")
	public Object[][] testingDP() {
		Object[][] myOptions = TestUtil.getTestData(sheetName);
		return myOptions;
	}
	
	@Test(priority=1, dataProvider="practiceMethod")
	public void startTest(String Name, String Gender, String Dob, String Address, String City, 
			String State, String PinNum, 
			String PhoneNum, String Email, String Passwurd) {
		System.out.printf(Name, Gender, Dob, Address, City, State, PinNum, PhoneNum, Email, Passwurd);
		
	}
	
	
}
