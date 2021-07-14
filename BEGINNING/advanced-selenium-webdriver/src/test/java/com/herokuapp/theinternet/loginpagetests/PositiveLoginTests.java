package com.herokuapp.theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPageObject;
import com.herokuapp.theinternet.pages.SecureAreaPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class PositiveLoginTests extends TestUtilities{

	@Test
	public void logInTest() {
		log.info("Starting logIn test");

		

		// open main page
		WelcomePageObject welcomePage= new WelcomePageObject(driver,log);
		welcomePage.openPage();
		
		takeScreenshot("WelcomePageObject");

		// Click on Form Authentication link
		LoginPageObject loginPage=welcomePage.clickFormAuthenticationLInk();
		
		takeScreenshot("LoginPageObject");

		// enter username and password and click login button
		SecureAreaPageObject secureAreaPage=loginPage.logIn("tomsmith","SuperSecretPassword!");
		
		takeScreenshot("SecureAreaPageObject");

		// verifications
		
		Assert.assertEquals(secureAreaPage.getCurrentURL(), secureAreaPage.returnExpUrl());

		// log out button is visible
		Assert.assertTrue(secureAreaPage.logOutButtonVisible(),"logOutButton is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getMessageContent();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

		
	}
}
