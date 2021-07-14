package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPageObject extends BasePageObject{
	
	private String expectedURL="http://the-internet.herokuapp.com/secure";
	private By logOutButton=By.xpath("//a[@class='button secondary radius']");
	private By successMessage=By.id("flash");

	public SecureAreaPageObject(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	public String returnExpUrl() {
		return expectedURL;
	}
	
	
	public boolean logOutButtonVisible() {
		return find(logOutButton).isDisplayed();
	}
	
	
	
	public String getMessageContent() {
		return find(successMessage).getText();
		
	}
	
	

}
