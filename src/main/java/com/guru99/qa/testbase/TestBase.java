package com.guru99.qa.testbase;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
/*import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;*/
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.guru99.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/deepsnaps/eclipse-workspace/guru99PracticePOM"
					+ "/src/main/java/com/guru99/qa/config/config.properties");
			prop.load(ip);	
			ip.close();
		} 
		catch (Exception e) {
			  e.printStackTrace();
		 } 
	}
	

	public static void initialization(String browserName) {
		//String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/deepsnaps/eclipse-workspace/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "/Users/deepsnaps/eclipse-workspace/geckodriver");
			driver = new FirefoxDriver();	
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
		
		driver.get(prop.getProperty("url"));
		
		
}
}
/*public static WebDriver driver;
public static Properties prop;
public TestBase() {
 try {
  prop = new Properties();
  FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + 
    "C:\\Users\\Ace\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
  prop.load(ip);

 } catch (FileNotFoundException e) {
  e.printStackTrace();
 } catch (IOException e) {
  e.printStackTrace();
 }

}

public static void initialization() {
 String browserName = prop.getProperty("browser");

 if (browserName.equals("chrome")) {
  System.setProperty("webdriver.chrome.driver",
    "C:\\Users\\Ace\\eclipse-workspace\\Selenium\\chromedriver.exe");
  driver = new ChromeDriver();
 }

 else if (browserName.equals("FF")) {
  System.setProperty("webdriver.gecko.driver",
    "C:\\Users\\Ace\\eclipse-workspace\\Selenium\\geckodriver.exe");
  driver = new FirefoxDriver();
 }
 
 driver.manage().window().maximize();
 driver.manage().deleteAllCookies();
 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); 
 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
 
 driver.get(prop.getProperty("url"));
}*/