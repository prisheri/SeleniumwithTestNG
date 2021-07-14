package com.herokuapp.theinternet.jsalerttests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JSAlertPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class JSAlertTests extends TestUtilities {

	private String resultMessage = null;
	private String alertText = null;

	@Test

	public void jsAlert() {

		log.info("Starting Java Script Alert test");

		// open page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on JavaScript Alerts link
		JSAlertPageObject jsAlertPage = welcomePage.clickJSAlertLink();

		// click on JS alert button
		jsAlertPage.openJSAlert();

		// get alert text
		alertText = jsAlertPage.getjsAlertText();

		// click ok button
		jsAlertPage.clickOkAlert();

		// get Result message
		resultMessage = jsAlertPage.getResulTtext();

		// verify text inside alert
		Assert.assertTrue(alertText.contains("I am a JS Alert"),
				"Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertText + "'");

		// verify text inside result
		Assert.assertTrue(resultMessage.contains("You successfully clicked an alert"),
				"Result message is not expected. \nShould be 'You successfully clicked an alert', but it is '"
						+ resultMessage + "'");

	}

	@Test
	public void jsConfirm() {

		log.info("Starting Java Script Confirm test");
		
		SoftAssert softassert=new SoftAssert();

		// open page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on JavaScript Alerts link
		JSAlertPageObject jsAlertPage = welcomePage.clickJSAlertLink();

		// click on JS alert button
		jsAlertPage.openJSConfirm();

		// get alert text
		alertText = jsAlertPage.getjsAlertText();

		// click cancel
		jsAlertPage.clickCancelAlert();

		// get Result message
		resultMessage = jsAlertPage.getResulTtext();

		// verify text inside alert
		softassert.assertTrue(alertText.contains("I am a JS Confirm23"),
				"Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertText + "'");

		// verify text inside result
		softassert.assertTrue(resultMessage.contains("You clicked: Cancel23"),
				"Result message is not expected. \nShould be 'You clicked: Cancel', but it is '" + resultMessage + "'");
		
		softassert.assertAll();
	}

	@Test
	public void jsPrompt() {

		log.info("Starting Java Script Prompt test");

		// open page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on JavaScript Alerts link
		JSAlertPageObject jsAlertPage = welcomePage.clickJSAlertLink();

		// click on JS prompt
		jsAlertPage.openJSPrompt();

		// get alert text
		alertText = jsAlertPage.getjsAlertText();

		// sending text in prompt
		jsAlertPage.typeTextinPrompt("Pritee");

		// get Result message
		resultMessage = jsAlertPage.getResulTtext();

		// verify text inside alert
		Assert.assertTrue(alertText.contains("I am a JS prompt"),
				"Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertText + "'");

		// verify text inside result
		Assert.assertTrue(resultMessage.contains("You entered: Pritee"),
				"Result message is not expected. \nShould be 'You entered: Pritee', but it is '" + resultMessage + "'");

	}

}
