package com.herokuapp.theinternet.base;

import java.io.File;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;

	public BrowserDriverFactory(String browser,Logger log) {
		this.browser = browser.toLowerCase();
		this.log=log;
	}

	public WebDriver createDriver() {
		// Create driver
		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			File pathBinary = new File("C:\\Users\\pritee.sheri\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary); 
			DesiredCapabilities desired = DesiredCapabilities.firefox();
			FirefoxOptions options = new FirefoxOptions();
			desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
			//driver = new FirefoxDriver(options);
			driver.set(new FirefoxDriver(options));
			break;

		default:
			log.info("Do not know how to start: " + browser + ", starting chrome.");
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		}

		return driver.get();
	}
}
