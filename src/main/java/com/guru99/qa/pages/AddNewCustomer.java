package com.guru99.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.testbase.TestBase;
import com.guru99.qa.util.TestUtil;

public class AddNewCustomer extends TestBase {
	
	@FindBy(xpath = "//input[@type='text' and @name='name']")
	WebElement newCustomerName;
	
	@FindBy(xpath = "//input[@type='radio' and @value='m']")
	WebElement maleBtn;
	
	@FindBy(xpath = "//input[@type='radio' and @value='f']")
	WebElement femaleBtn;
	
	@FindBy(xpath = "//input[@name='dob']")
	WebElement dobField;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement addressField;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement cityField;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement stateField;
	
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pinField; //must be 6 digits
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement phoneNumField;
	
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passField;
	
	@FindBy(xpath = "//input[@name='sub']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueBtn;
	
	TestUtil testUtil;
	
	public AddNewCustomer() {
		PageFactory.initElements(driver, this);
	}
	
	public void addNewCustomerInfo() throws InterruptedException {
		/*newCustomerName.isEnabled();
		System.out.println("is element displayed" + newCustomerName.isEnabled());
		newCustomerName.sendKeys("Million Aire");
		maleBtn.click();
		maleBtn.isSelected();
		dobField.sendKeys("08/23/1986");
		addressField.sendKeys("6708 N CashMoney St");
		cityField.sendKeys("Millions");
		stateField.sendKeys("Millionaires");
		pinField.sendKeys("123456");
		phoneNumField.sendKeys("1231231234");
		emailField.sendKeys("million@million.com");
		passField.sendKeys("millionaireClub");
		submitBtn.click();
		Thread.sleep(3000);*/
		
		newCustomerName.isEnabled();
		System.out.println("is element displayed" + newCustomerName.isEnabled());
		newCustomerName.sendKeys("Steve Jobs");
		maleBtn.click();
		maleBtn.isSelected();
		dobField.sendKeys("08/23/1986");
		addressField.sendKeys("6708 N CashMoney St");
		cityField.sendKeys("Millions");
		stateField.sendKeys("Millionaires");
		pinField.sendKeys("123458");
		phoneNumField.sendKeys("1231231235");
		emailField.sendKeys("billion@billion.com");
		passField.sendKeys("billionaireClub");
		submitBtn.click();
		Thread.sleep(3000);
	}
	
	public void getCustoID() throws IOException {
		WebElement registerTable = driver.findElement(By.xpath("//table[@id='customer']//tr[4]"));
		List<WebElement> itemsInTable = registerTable.findElements(By.tagName("td"));
		
		int size = itemsInTable.size();
		System.out.println("The size of the list is: " + size);
		for (int i = 0; i < size; i++) {
			System.out.println(itemsInTable.get(i).getText());
			String name = itemsInTable.get(0).getText();
			String id = itemsInTable.get(1).getText();
			testUtil.writeToConfig(name, id);
			testUtil.getScreenShotForExtent("CustomerID");
		}
		
		
	}
	

}
