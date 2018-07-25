package com.guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.guru99.qa.testbase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//h2[@class='barone' and contains(text(),'Guru99 Bank')]")
	WebElement homePageTitle;
	
	@FindBy(xpath = "//marquee[@class='heading3' and contains(text(),'Guru99 Bank')]")
	WebElement movingGuruTitle;
	
	@FindBy(linkText = "New Customer")
	WebElement newCustomerTab;
	
	@FindBy(linkText = "Edit Customer")
	WebElement editCustomerTab;
	
	@FindBy(linkText = "Delete Customer")
	WebElement deleteCustomerTab;
	
	@FindBy(linkText = "New Account")
	WebElement newAccountTab;
	
	@FindBy(linkText = "Edit Account")
	WebElement editAccountTab;
	
	@FindBy(linkText = "Deposit")
	WebElement depositTab;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void homePageTitleVisible() {
		String hpTitle = driver.getTitle();
		Assert.assertEquals(hpTitle, "Guru99 Bank Manager HomePage");
	}
	
	
	public String verifyMovingGuru() {
		if (movingGuruTitle.isDisplayed()) {
			String movingTitle = movingGuruTitle.getText();
			return movingTitle;
		}
		else if (movingGuruTitle.isDisplayed()) {
			String realMovingTitle = movingGuruTitle.getText();
			return realMovingTitle;
			
		}
		else {
			return null;
		}
	}
	
	public AddNewCustomer clickNewCustomer() {
		newCustomerTab.getText();
		newCustomerTab.click();
		return new AddNewCustomer();
		
	}
	

}
