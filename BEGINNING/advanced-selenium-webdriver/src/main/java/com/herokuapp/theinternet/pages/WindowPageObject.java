package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPageObject extends BasePageObject{
	
	private By newWindowLinkLocator=By.linkText("Click Here");

	public WindowPageObject(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	public void clickNewWindowLink() {
		log.info(" Clicking new window link");
		click(newWindowLinkLocator);
		
	}
	
	/** Find page with title "New Window" and switch to it */
	public NewWindowPageObject switchtoNewWindow() {
		log.info("Looking for 'New Window' page");
		switchToWindowWithTitle("New Window");
		return new NewWindowPageObject(driver, log);
	}

}
