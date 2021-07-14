package com.herokuapp.theinternet.dropdowntests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropDownPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class DropdownTests extends TestUtilities {

	@Test
	public void selectDropdownTest() {

		log.info("Starting dropdown test");

		// open page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on dropdown link
		DropDownPageObject dropDownPage=welcomePage.clickDropdownLink();
		
		// select option 2 from dropdown
		dropDownPage.selectOption(2);
		
		// check if option 2 is selected
		String selectedValue=dropDownPage.getSelectedValue();
		Assert.assertTrue(selectedValue.trim().equals("Option 2"),"Selected value is not equal to Option 2");

	}

}
