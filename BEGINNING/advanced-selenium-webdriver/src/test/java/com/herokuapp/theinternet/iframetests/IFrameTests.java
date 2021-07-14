package com.herokuapp.theinternet.iframetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.IFramePageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class IFrameTests extends TestUtilities{
	
	@Test
	public void iFrameTests() {
	
	log.info("Starting IFrame test");

	// open page
	WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
	welcomePage.openPage();
	
	//scroll to bottom of the page
	sleep(5000);
	welcomePage.scrollatBottomofthePage();
	sleep(5000);

	// click on WYSIWYG Editor link
	IFramePageObject iFramePage = welcomePage.clickWYSIWYGEditorLink();
	
	//capture the text of editor
	String text=iFramePage.getEditorText();
	
	
	Assert.assertEquals(text, "Your content goes here.");
	}

}
