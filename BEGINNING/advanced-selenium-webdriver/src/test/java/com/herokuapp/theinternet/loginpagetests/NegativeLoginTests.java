package com.herokuapp.theinternet.loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class NegativeLoginTests extends TestUtilities {

	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLoginTest(Map<String, String> testData) {

		// Data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expected error message");
		String description = testData.get("description");
		
		log.info("Starting negativeLogInTest #" + no + " for " + description);

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPageObject loginPage = welcomePage.clickFormAuthenticationLInk();

		// enter username and password
		loginPage.negativeLogIn(username, password);

		// Verification
		loginPage.waitForErrorMessage();
		String actualErrorMessage = loginPage.getErrorMesage();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}

}
