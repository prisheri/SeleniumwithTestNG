package com.herokuapp.theinternet.hovertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoverPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class HoverTests extends TestUtilities{
	
	@Test
	public void hoverOverTests() {
	
	log.info("Starting Hover test");

	// open page
	WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
	welcomePage.openPage();
	
	//click on hover link
	HoverPageObject hoverPage=welcomePage.clicKHoversLink();
	
	//hover over 2nd image and click view profile link
	hoverPage.hoverOverImage(2);
	
	Assert.assertTrue(hoverPage.getCurrentURL().contains("/users/2"), "Profile is incorrect "+hoverPage.getCurrentURL());
	
	}

}
