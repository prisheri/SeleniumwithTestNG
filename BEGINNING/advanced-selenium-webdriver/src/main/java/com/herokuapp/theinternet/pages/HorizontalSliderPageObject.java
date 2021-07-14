package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPageObject extends BasePageObject {

	private By slider = By.xpath("//input[@type='range']");
	private By range = By.id("range");

	public HorizontalSliderPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void setSliderTo(String value) {
		log.info("setting slider to " + value);

		// Move slider normal method
		// Find the xOffset using given value
		// int width = find(slider).getSize().getWidth();
		// double percent = Double.parseDouble(value) / 5;
		// int xOffset = (int) (width * percent);

		// Actions action = new Actions(driver);
		// action.dragAndDropBy(find(slider), xOffset, 0).build().perform();

		// Workaround method
		// Calculate number of steps
		
		//find(slider).getAttribute("step");

		int steps = (int) (Double.parseDouble(value) / 0.5);

		// Perform steps
		pressKey(slider, Keys.ENTER);
		for (int i = 0; i < steps; i++) {
			pressKey(slider, Keys.ARROW_RIGHT);

		}
	}
	
	public String getRange() {
		String rangeValue=find(range).getText();
		log.info("Slider value is " + rangeValue);
		return rangeValue;
	}

}
