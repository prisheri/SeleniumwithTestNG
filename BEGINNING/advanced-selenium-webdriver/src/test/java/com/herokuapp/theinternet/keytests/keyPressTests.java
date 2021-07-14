package com.herokuapp.theinternet.keytests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class keyPressTests extends TestUtilities{
	
	@Test
	public void keyPress() {
		
		log.info("Starting Key Press test");

		// open page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on key Press link
		KeyPressObject keyPress = welcomePage.clicKeyPressesLink();
		
		//press key
		keyPress.pressKeyAction(Keys.F7);
		//get Result text
		String output=keyPress.getResultText();
		
		Assert.assertEquals(output, "You entered: F7");
		
	}

}
