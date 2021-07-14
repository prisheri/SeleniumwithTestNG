package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPageObject extends BasePageObject{
	
	private By checkboxLocator=By.xpath("//input[@type='checkbox']");

	public CheckboxPageObject(WebDriver driver, Logger log) {
		super(driver,log);
		// TODO Auto-generated constructor stub
	}
	
	public void selectAllCheckboxes() {
		log.info("Selecting all unselected checkboxes");
		waitForVisibilityOf(checkboxLocator, 5);
		List<WebElement> checkBoxesList=findAll(checkboxLocator);
		for(WebElement checkBoxes : checkBoxesList) {
			if (!checkBoxes.isSelected())
			checkBoxes.click();
		}
		
	}
	
	public boolean isAllCheckboxesSelected() {
		log.info("Checking for all selected checkboxes");
		List<WebElement> checkBoxesList=findAll(checkboxLocator);
		for(WebElement checkBoxes : checkBoxesList) {
			if (!checkBoxes.isSelected())
			return false;
		}
		return true;
		
	}
	
	
	
	

}
