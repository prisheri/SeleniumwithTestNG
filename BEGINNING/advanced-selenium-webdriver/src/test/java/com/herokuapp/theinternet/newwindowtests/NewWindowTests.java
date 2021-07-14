package com.herokuapp.theinternet.newwindowtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import com.herokuapp.theinternet.pages.WindowPageObject;

public class NewWindowTests extends TestUtilities{
	
	@Test
	public void openNewWindowTest() {
		log.info("Starting Multiple Window test");

		// open page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on Mutiple windows link
		WindowPageObject windowPage = welcomePage.clickmultipleWindowLink();
		
		// click on new window link
		windowPage.clickNewWindowLink();
		
		sleep(2000);
		
		//switch to new window with title
		NewWindowPageObject newWindowPage=windowPage.switchtoNewWindow();
		
		String pgSource=newWindowPage.getCurrentPageSource();
		
		Assert.assertTrue(pgSource.contains("New Window"), "New page source doesn't contain expected text");
		

	}
	

	

}
