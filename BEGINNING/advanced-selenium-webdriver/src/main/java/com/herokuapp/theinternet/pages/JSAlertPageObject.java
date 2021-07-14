package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertPageObject extends BasePageObject{
	
	private By jsAlertBtnLocator=By.xpath("//button[text()='Click for JS Alert']");
	private By jsConfirmBtnLocator=By.xpath("//button[text()='Click for JS Confirm']");
	private By jsPromptBtnLocator=By.xpath("//button[text()='Click for JS Prompt']");
	private By resultTextLocator=By.id("result");
	

	public JSAlertPageObject(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	public void openJSAlert() {
		log.info("Clicking on 'Click for JS Alert' button to open alert");
		click(jsAlertBtnLocator);
	}
	
	public void openJSConfirm() {
		log.info("Clicking on 'Click for JS Confirm' button to open alert");
		click(jsConfirmBtnLocator);
	}
	
	public void openJSPrompt() {
		log.info("Clicking on 'Click for JS Prompt' button to open alert");
		click(jsPromptBtnLocator);
	}
	
	public String getjsAlertText() {
		Alert alert=switchToAlert(); 
		String alertText=alert.getText();
		log.info("text in alert is "+alertText);
		return alertText;
	}
	
	public void clickOkAlert() {
		log.info("Switching to alert and pressing OK");
		Alert alert = switchToAlert();
		alert.accept();
	}
	
	public void clickCancelAlert() {
		log.info("Switching to alert and pressing Cancel");
		Alert alert = switchToAlert();
		alert.dismiss();
	}
	
	public void typeTextinPrompt(String text) {
		log.info("Switching to alert and entering text");
		Alert alert = switchToAlert();
		alert.sendKeys(text);
		alert.accept();
	}
	
	public String getResulTtext() {
		
		String resultMsg=find(resultTextLocator).getText();
		log.info(" Result message is "+resultMsg);
		return resultMsg;
	}
	
	
	
	

}
