package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyPressObject extends BasePageObject{
	
	By resultLocator=By.id("result");
	By editBoxLocator=By.id("target");
	
	public KeyPressObject(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	
	
	public String getResultText() {
		
		String message=find(resultLocator).getText();
		log.info("Result message is "+message);
		return message;
		
	}

}
