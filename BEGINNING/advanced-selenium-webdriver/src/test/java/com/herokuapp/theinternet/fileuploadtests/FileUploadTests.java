package com.herokuapp.theinternet.fileuploadtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploadPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class FileUploadTests extends TestUtilities{

	@Test(dataProvider ="files")
	public void fileUpload(int i, String fileName) {
		
		log.info(" running file upload test no. "+i+" for file: "+fileName);

		// open page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// click on File Upload link
		FileUploadPageObject fileUploadPage = welcomePage.clicKeyFileUploadLink();
		
		//select file to upload and click upload button
		fileUploadPage.fileUpload(fileName);
		
		//get the name of uploaded file
		Assert.assertEquals(fileUploadPage.getUploadedFile(), fileName);

	}

}
