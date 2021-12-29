package com.crm.autodesk.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.pomReposityLib.ContactPage;
import com.crm.autodesk.pomReposityLib.ContactsInfoPage;
import com.crm.autodesk.pomReposityLib.CreateContactPage;
import com.crm.autodesk.pomReposityLib.HomePage;
import com.crm.autodesk.pomReposityLib.LoginPage;
import com.crm.autodest.genericUtility.BaseClass;
import com.crm.autodest.genericUtility.ExcelUtility;
import com.crm.autodest.genericUtility.FileUtility;
import com.crm.autodest.genericUtility.JavaUtility;
import com.crm.autodest.genericUtility.WebDriverUtility;

public class CreateContact extends BaseClass{
	
	@Test(groups = "smokeSuite")
	public  void createContactTest() throws EncryptedDocumentException, IOException{
		
		
		int randomNum = jLib.getRanDomNumber();
		
		String CONTACT = eLib.getDataFromExcel("contact", 1, 2) + randomNum;
		
	
		
        HomePage hp = new HomePage(driver);
        hp.clickOnContactsLink();
        
        ContactPage cp = new ContactPage(driver);
        cp.clickOnCreateContact();
        
        CreateContactPage ccp = new CreateContactPage(driver);
        		ccp.createContact(CONTACT);
        		
        ContactsInfoPage cip = new ContactsInfoPage(driver);
        String ActMsg = cip.getcontactInfo();
		
		Assert.assertTrue(ActMsg.contains(CONTACT));
		System.out.println("contact created sucessfully");
		
		/*SoftAssert sa = new SoftAssert();
		sa.assertTrue(ActMsg.contains(CONTACT));
		Reporter.log("contact created", true);
		sa.assertAll();*/
	}
	@Test
	public void demo()
	{
		System.out.println("demo");
	}
}
