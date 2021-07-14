package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePageObject{


	
	public LoginPageObject(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	private By userNameLocator=By.id("username");
	private By passwordLocator=By.id("password");
	private By logInButtonLocator=By.className("radius");
	private By errorMesgLocator=By.id("flash");
	
	public SecureAreaPageObject logIn(String userName, String password) {
		log.info("Logging with username "+userName+" and password "+password);
		type(userName,userNameLocator);
		type(password,passwordLocator);
		click(logInButtonLocator);
		return new SecureAreaPageObject(driver,log);
		
	}

	public void negativeLogIn(String userName, String password) {
		log.info("Negative Logging with username "+userName+" and password "+password);
		type(userName,userNameLocator);
		type(password,passwordLocator);
		click(logInButtonLocator);
		
	}
	
	public void waitForErrorMessage() {
		waitForVisibilityOf(errorMesgLocator,5);
		
	}
	
	public String getErrorMesage() {
		return find(errorMesgLocator).getText();
	}
	
}
