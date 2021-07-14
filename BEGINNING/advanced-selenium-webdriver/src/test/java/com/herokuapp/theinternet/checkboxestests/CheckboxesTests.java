package com.herokuapp.theinternet.checkboxestests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class CheckboxesTests extends TestUtilities{
	
	@Test
	public void selectTwoCheckboxesTests() {
		
		log.info("Starting checkbox test");
		
		//open page
		WelcomePageObject welcomePage= new WelcomePageObject(driver,log);
		welcomePage.openPage();
		
		//click on checkbox link
		CheckboxPageObject checkboxPage=welcomePage.clickCheckboxesLink();
		
		//select 2 checkboxes
		checkboxPage.selectAllCheckboxes();
		//verify all checkboxes are checked
		Assert.assertTrue(checkboxPage.isAllCheckboxesSelected(), "Not all checkboxes are selected");
		
	}
	

}
