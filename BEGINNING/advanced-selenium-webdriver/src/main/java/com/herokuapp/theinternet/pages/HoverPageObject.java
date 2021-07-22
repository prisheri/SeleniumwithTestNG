package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoverPageObject extends BasePageObject {
    private By image = By.xpath("//div[@class='figure']");
    private By link = By.xpath(".//a[contains(text(),'View profile')]");


    public HoverPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void hoverOverImage(int i) {
        log.info("Hovering over image " + i);
        List<WebElement> images = findAll(image);
        WebElement imageToHover = images.get(i - 1);
        hoverOverElement(imageToHover);
        imageToHover.findElement(link).click();


    }

}
