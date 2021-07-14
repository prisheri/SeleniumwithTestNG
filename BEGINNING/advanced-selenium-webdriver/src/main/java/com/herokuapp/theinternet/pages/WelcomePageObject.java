package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {
	
	
	
	private String url = "http://the-internet.herokuapp.com/";
	
	private By formAuthenticationLinkLocator=By.linkText("Form Authentication");
	private By checkboxesLinkLocator=By.linkText("Checkboxes");
	private By dropdownLinkLocator=By.linkText("Dropdown");
	private By jsAlertsLinkLocator=By.linkText("JavaScript Alerts");
	private By multipleWindowLinkLocator=By.linkText("Multiple Windows");
	private By editorLinkLocator=By.linkText("WYSIWYG Editor");
	private By keyPressLocator=By.linkText("Key Presses");
	private By fileUploadLocator=By.linkText("File Upload");
	private By dragDropLocator=By.linkText("Drag and Drop");
	private By hoverLinkLocator=By.linkText("Hovers");
	private By horizontalSliderLinkLocator=By.linkText("Horizontal Slider");

	public WelcomePageObject(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	//Open welcome page with URL
	public void openPage() {
		log.info("Opening Page "+url);
		openURL(url);
		log.info("Page is opened !");
		
	}
	
	public LoginPageObject clickFormAuthenticationLInk() {
		log.info("Clicking Form Authentication link");
		click(formAuthenticationLinkLocator);
		return new LoginPageObject(driver,log);
	}
	
	public CheckboxPageObject clickCheckboxesLink() {
		log.info("Clicking Checkboxes link");
		click(checkboxesLinkLocator);
		return new CheckboxPageObject(driver,log);
	}
	
	public DropDownPageObject clickDropdownLink() {
		log.info("Clicking Dropdown link");
		click(dropdownLinkLocator);
		return new DropDownPageObject(driver,log);
	}
	
	public JSAlertPageObject clickJSAlertLink() {
		log.info("Clicking Java script alert link");
		click(jsAlertsLinkLocator);
		return new JSAlertPageObject(driver,log);
	}
	
	public WindowPageObject clickmultipleWindowLink() {
		log.info("Clicking Multiple Window link");
		click(multipleWindowLinkLocator);
		return new WindowPageObject(driver,log);
	}
	
	public IFramePageObject clickWYSIWYGEditorLink() {
		log.info("Clicking WYSIWYG Editor link");
		click(editorLinkLocator);
		return new IFramePageObject(driver,log);
	}
	
	public KeyPressObject clicKeyPressesLink() {
		log.info("Clicking Key Presses link");
		click(keyPressLocator);
		return new KeyPressObject(driver,log);
	}
	
	public FileUploadPageObject clicKeyFileUploadLink() {
		log.info("Clicking File Upload link");
		click(fileUploadLocator);
		return new FileUploadPageObject(driver,log);
	}
	
	public dragDropPageObject clicKdragDropLink() {
		log.info("Clicking Drag and Drop link");
		click(dragDropLocator);
		return new dragDropPageObject(driver,log);
	}
	
	public HoverPageObject clicKHoversLink() {
		log.info("Clicking Hovers link");
		click(hoverLinkLocator);
		return new HoverPageObject(driver,log);
	}
	
	public HorizontalSliderPageObject clicKHorizontalSliderLink() {
		log.info("Clicking Horizontal Slider link");
		click(horizontalSliderLinkLocator);
		return new HorizontalSliderPageObject(driver,log);
	}
	


	

}
