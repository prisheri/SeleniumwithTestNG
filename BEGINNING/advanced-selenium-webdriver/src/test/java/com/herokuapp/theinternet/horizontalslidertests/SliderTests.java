package com.herokuapp.theinternet.horizontalslidertests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class SliderTests extends TestUtilities{
	
	@Test
	public void horizontalSliderTests() {
	
	log.info("Starting horizontal slider test");

	// open page
	WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
	welcomePage.openPage();
	
	//click on Horizontal Slider link
	HorizontalSliderPageObject horizontalSlider=welcomePage.clicKHorizontalSliderLink();
	
	String sliderValue="2.5";
	
	//move slider
	horizontalSlider.setSliderTo(sliderValue);
	
	sleep(5000);
	
	Assert.assertEquals(horizontalSlider.getRange(), sliderValue);
	
	
	
	}
	
	

}
