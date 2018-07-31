package com.guru99.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.guru99.qa.testbase.TestBase;


public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static String TESTDATA_SHEET_PATH = "/Users/deepsnaps/eclipse-workspace/guru99PracticePOM"
			+ "/src/main/java/com/guru99/qa/testdata/guru99dataEXCEL.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	
	
	public TestUtil() {
		
	}
	
	
	//Get ScreenShot - First Way to do it:
	public static void getScreenShot(String fileName) throws IOException {
		// 1. Take Screenshot and store it as a file format.. rmr take screen shot returns file object so create object
		// of the class File...
		File fiLe = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// 2. now copy the screenshot using copyfile method to the desired location
		FileUtils.copyFile(fiLe, new File("/Users/deepsnaps/eclipse-workspace/"
				+ "guru99PracticePOM/src/main/java/com/guru99/qa/pages"+fileName+".png"));
		
	}
	
	//Get ScreenShot - Second Way to do it:
	public static String getScreenShotForExtent(String nameYourFile) throws IOException {
		String fileDate = new SimpleDateFormat("MM-dd-yyyy - hh:mm:ss").format(new Date());
		TakesScreenshot takeshot = (TakesScreenshot) driver;
		File source = takeshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/GuruScreenShots/" + nameYourFile + fileDate + ".png";
		File finalDestination = new File (destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	//How to write to config.properties file:
	public static void writeToConfig(String key, String value) {
		prop.setProperty(key, value);
		try {
			prop.store(new FileOutputStream("/Users/deepsnaps/eclipse-workspace/guru99PracticePOM"
					+ "/src/main/java/com/guru99/qa/config/config.properties"), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//How to get Test Data from Excel File:
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}
		catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
		
		
	}
	
	
	
	
	
	
}
