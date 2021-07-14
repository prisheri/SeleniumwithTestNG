package com.herokuapp.theinternet.draganddroptests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import com.herokuapp.theinternet.pages.dragDropPageObject;

public class DragandDrop extends TestUtilities {
	
	@Test
	public void dragAndDropTests() {
	
	log.info("Starting drag and drop test");

	// open page
	WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
	welcomePage.openPage();
	
	//click Drag and drop link
	dragDropPageObject dragDrop=welcomePage.clicKdragDropLink();
	
	//Drag and drop A to B
	dragDrop.dragAndDropAtoB();
	
	sleep(5000);
	
	Assert.assertEquals(dragDrop.getColumnAtext(), "B");
	
	Assert.assertEquals(dragDrop.getColumnBtext(), "A");
	
	
	}

}
