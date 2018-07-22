package com.guru99.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.guru99.qa.testbase.TestBase;


public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//h2[contains(text(),'Guru99 Bank')]")
	WebElement loginTitle;
	
	@FindBy(xpath = "//input[@name='uid']")
	WebElement userField;
	
	@FindBy(css = "input[type='password']")
	WebElement passField;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement loginBtn;
	
	@FindBy(css = "input[value='RESET']")
	WebElement resetBtn;
	
	@FindBy(xpath = "//img[@alt='Guru99 Demo Sites']")
	WebElement guruLogo;
	
	@FindBy(id = "site-name")
	WebElement siteName;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle' and contains(text(),'Selenium')]")
	WebElement seleniumTab;
	
	@FindBy(linkText = "Insurance Project")
	WebElement insuranceProjectTab;
	
	@FindBy(partialLinkText = "Agile")
	WebElement agileProductTag;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle' and contains(text(),'Bank Project')]")
	WebElement bankProjectTab;
	
	@FindBy(partialLinkText = "curity")
	WebElement securityProjectTab;
	
	@FindBy(partialLinkText = "elecom")
	WebElement telecomProjectTab;
	
	@FindBy(linkText = "Payment Gateway Project")
	WebElement paymentGatewayProjectTab;
	
	@FindBy(linkText = "New Tours")
	WebElement newToursTab;
	
	@FindBy(xpath = "//a[contains(text(),'here')]")
	WebElement viewLink;
	
	public static final Logger logga = LogManager.getLogger("LoginPage");
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage letsLogin(String un, String pwd) {
		logga.info("works MOTHERFUCKER!");
		userField.sendKeys(un);
		passField.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
		
		
	}
	
	
	
	
}
