package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePageObject extends BasePageObject{
	
	private By iFrameLocator=By.id("mce_0_ifr");
	private By editorLocator=By.id("tinymce");

	public IFramePageObject(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	public String getEditorText() {
		
		switchToFrame(iFrameLocator);
		String text=find(editorLocator).getText();
		log.info("Text in editor is "+text);
		return text;
		
	}

}
