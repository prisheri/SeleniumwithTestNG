package com.herokuapp.theinternet.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest{
	
	protected void sleep(long timemili) {
		try {
			Thread.sleep(timemili);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="files")
	public static Object[][] fileData(){
		return new Object[][]{{ 1, "image.png"} ,  {2,"test.txt"} ,{3, "demo.properties"}};
	}
	
	public void takeScreenshot(String fileName) {
		File screenshotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filePath=System.getProperty("user.dir") 
				+ File.separator + "test-output" 
				+ File.separator + "screenshots"
				+ File.separator + getTodaysDate() 
				+ File.separator + testSuiteName 
				+ File.separator + testName
				+ File.separator + testMethodName 
				+ File.separator + getSystemTime() 
				+ " " + fileName + ".png";
		try {
			FileUtils.copyFile(screenshotFile, new File(filePath));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static String getTodaysDate() {
		
		return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}
	
	private String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}
	
	

}
