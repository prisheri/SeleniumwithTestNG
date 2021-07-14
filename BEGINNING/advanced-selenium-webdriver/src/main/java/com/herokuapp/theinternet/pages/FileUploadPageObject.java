package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPageObject extends BasePageObject{
	
	private By chooseFileUploadLocator= By.id("file-upload");
	private By submitFileUploadLocator= By.id("file-submit");
	private By resultFileUploadLocator= By.id("uploaded-files");

	public FileUploadPageObject(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	public void fileUpload(String fileName) {
		log.info("Uploading File "+fileName);
		String filePath=System.getProperty("user.dir")+"/src/main/resources/files/"+fileName;
		type(filePath,chooseFileUploadLocator);
		log.info("click submit button");
		click(submitFileUploadLocator);
	}
	
	public String getUploadedFile() {
		String fielName=find(resultFileUploadLocator).getText();
		log.info("Uploaded file name is "+fielName);
		return fielName;
	}
	
	

}
