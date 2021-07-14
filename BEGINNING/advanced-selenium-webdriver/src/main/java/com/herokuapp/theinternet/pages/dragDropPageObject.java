package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dragDropPageObject extends BasePageObject{
	
	private By columnA=By.id("column-a");
	private By columnB=By.id("column-b");

	public dragDropPageObject(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	public void dragAndDropAtoB() {
		log.info("dragging A and dropping to B");
		dragAndDrop(columnA,columnB);
		
	}
	
	public String getColumnAtext() {
		String text=find(columnA).getText();
		log.info("column A text "+text);
		return text;
		
	}
	
	public String getColumnBtext() {
		String text=find(columnB).getText();
		log.info("column B text "+text);
		return text;
		
	}

}
