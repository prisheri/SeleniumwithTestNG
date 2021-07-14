package com.herokuapp.theinternet.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	protected WebDriver driver;
	protected Logger log;

	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

	protected void openURL(String url) {
		driver.get(url);
	}

	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}

	protected void click(By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).click();
	}

	protected void type(String text, By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).clear();
		find(locator).sendKeys(text);
	}

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOut) {
		timeOut = timeOut != null ? timeOut : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(condition);

	}

	protected void waitForVisibilityOf(By locator, Integer... timeOut) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator), timeOut.length > 0 ? timeOut[0] : null);
				break;

			} catch (StaleElementReferenceException e) {

			}

			attempts++;
		}

	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();

	}
	
	/** Get title of current page */
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}

	/** Get source of current page */
	public String getCurrentPageSource() {
		return driver.getPageSource();
	}

	public void switchToWindowWithTitle(String title) {

		String currentWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> windowIterator = allWindows.iterator();

		while (windowIterator.hasNext()) {
			String windowHandle = windowIterator.next().toString();
			if (!windowHandle.equals(currentWindow)) {
				driver.switchTo().window(windowHandle);
				if (getCurrentPageTitle().equals(title))
					break;
			}

		}

	}
	
	protected void switchToFrame(By frameLocator) {
		
		driver.switchTo().frame(find(frameLocator));
		
	}
	
	protected void pressKey(By locator, Keys key) {
		find(locator).sendKeys(key);
	}
	
	public void pressKeyAction(Keys key ) {
		log.info("pressing key "+key.name());
		Actions action=new Actions(driver);
		action.sendKeys(key).build().perform();
		
	}
	
	public void scrollatBottomofthePage() {
		log.info("scrolling with JS executor");
		JavascriptExecutor jsExe=(JavascriptExecutor) driver;
		jsExe.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	
	protected void dragAndDrop(By from,By to) {
		//Actions action=new Actions(driver);
		//action.dragAndDrop(find(from), find(to)).build().perform();
		JavascriptExecutor jsExe=(JavascriptExecutor) driver;
		jsExe.executeScript(
				"function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
						+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
						+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
						+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
						+ "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
						+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
						+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
						+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
						+ "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
						+ "var dragStartEvent =createEvent('dragstart');\n"
						+ "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
						+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
						+ "var dragEndEvent = createEvent('dragend');\n"
						+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
						+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
						+ "simulateHTML5DragAndDrop(source,destination);",
				find(from), find(to));
		
	}
	
	protected void hoverOverElement(WebElement ele) {
		Actions action=new Actions(driver);
		action.moveToElement(ele).build().perform();
	}
}
