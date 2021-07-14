package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPageObject extends BasePageObject {
	
	private By dropdownLocator=By.id("dropdown");

	public DropDownPageObject(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	
	public void selectOption(int i) {
		log.info("Selecting option "+i+" from dopdown");
		WebElement dropdownElement=find(dropdownLocator);
		Select selectDD=new Select(dropdownElement);
		// selectDD.selectByIndex(i);
		
		selectDD.selectByValue(""+i);
		
		//selectDD.selectByVisibleText("Option "+1);
		
		
	}
	
	public String getSelectedValue() {
		log.info("Checking for selected value from dopdown");
		WebElement dropdownElement=find(dropdownLocator);
		Select selectDD=new Select(dropdownElement);
		
		String value= selectDD.getFirstSelectedOption().getText();
		log.info("Selected option is "+value);
		return value;
		
		
	}
	
	

}
