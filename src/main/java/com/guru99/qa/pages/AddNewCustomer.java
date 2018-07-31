package com.guru99.qa.pages;

import java.io.IOException;
import java.util.List;
import java.util.Set;

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
	
	String boy = "male";
	String girl = "female";
	

	
	public AddNewCustomer() {
		PageFactory.initElements(driver, this);
	}
	
	public void addNewCustomerInfo(String name, String gender, String dob, String address, 
			String city, String state, String pinNum, String phoneNum, 
			String email, String passwurd) throws InterruptedException, IOException {
		
		newCustomerName.isEnabled();
		System.out.println("Is Customer Name element displayed? " + newCustomerName.isEnabled());
		newCustomerName.sendKeys(name);
		
		if (gender.equals(boy)) {
			maleBtn.click();
			maleBtn.isSelected();
		}
		else if (gender.equals(girl)) {
			femaleBtn.click();
			femaleBtn.isSelected();
		}
		else {
			System.out.println(gender + " is not a valid Gender");
		}
		
		dobField.sendKeys(dob);
		addressField.sendKeys(address);
		cityField.sendKeys(city);
		stateField.sendKeys(state);
		pinField.sendKeys(pinNum);
		phoneNumField.sendKeys(phoneNum);
		emailField.sendKeys(email);
		passField.sendKeys(passwurd);
		submitBtn.click();
		Thread.sleep(3000);
		
		WebElement custoIDnum = driver.findElement(By.xpath("//table[@id='customer']//tr[4]/td[2]"));
		String idNumCusto = custoIDnum.getText();
		System.out.println(idNumCusto);
		TestUtil.writeToConfig(name, idNumCusto);
		TestUtil.getScreenShotForExtent("CustomerID");
		
		
		/*newCustomerName.isEnabled();
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
		Thread.sleep(3000);*/
	}
	
	public void getCustoID() throws IOException {
		
		/*WebElement custoIDnum = driver.findElement(By.xpath("//table[@id='customer']//tr[4]/td[2]"));
		String idNumCusto = custoIDnum.getText();
		System.out.println(idNumCusto);
		TestUtil.writeToConfig("ID is: ", idNumCusto);
		TestUtil.getScreenShotForExtent("CustomerID");*/
		
		
		
	/*	String[] myArray = {};    
		int currentSize = myArray.length;
		int newSize = currentSize + 1;
		String[] tempArray = new String[newSize];
		for (int i=0; i < currentSize; i++)
		{
		    tempArray[i] = myArray [i];
		}
		tempArray[newSize- 1] = idNumCusto;
		myArray = tempArray;   
		for (String element:myArray ) {
		    System.out.println(element);
		}
		*/
	
		
		/*	WebElement registerTable = driver.findElement(By.xpath("//table[@id='customer']//tr[4]"));
		List<WebElement> itemsInTable = registerTable.findElements(By.tagName("td"));
		
		int size = itemsInTable.size();
		System.out.println("The size of the list is: " + size);
		for (int i = 0; i < size; i++) {
			String nameNid = itemsInTable.get(i).getText().toString();
			//System.out.println(itemsInTable.get(i).getText());
			String configName = itemsInTable.get(0).getText();
			String configId = itemsInTable.get(1).getText();
			testUtil.writeToConfig(configName, configId);
			testUtil.getScreenShotForExtent("CustomerID");
		}
		*/
		
	}
	

}
