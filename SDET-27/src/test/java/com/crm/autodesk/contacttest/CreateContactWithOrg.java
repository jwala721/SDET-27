package com.crm.autodesk.contacttest;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.pomReposityLib.ContactPage;
import com.crm.autodesk.pomReposityLib.CreateContactPage;
import com.crm.autodesk.pomReposityLib.CreateOrganizationPage;
import com.crm.autodesk.pomReposityLib.HomePage;
import com.crm.autodesk.pomReposityLib.LoginPage;
import com.crm.autodesk.pomReposityLib.OrganizationsPage;
import com.crm.autodest.genericUtility.BaseClass;
import com.crm.autodest.genericUtility.ExcelUtility;
import com.crm.autodest.genericUtility.FileUtility;
import com.crm.autodest.genericUtility.JavaUtility;
import com.crm.autodest.genericUtility.WebDriverUtility;

@Listeners(com.crm.autodest.genericUtility.ListenersImplementation.class)
public class CreateContactWithOrg extends BaseClass{
   
	@Test(groups = "RegressionSuite")
	public  void createContactWithOrgTest() throws InterruptedException, EncryptedDocumentException, IOException {
		
		
		
		int randomNum = jLib.getRanDomNumber();
		
	
		
		String orgName = eLib.getDataFromExcel("org", 1, 2) + randomNum;
		String CONTACT = eLib.getDataFromExcel("contact", 1, 2) + randomNum;
	
	
	
	
	 HomePage hp = new HomePage(driver);
	 
	 hp.clickOnorganizationsLnk();
	 OrganizationsPage op = new OrganizationsPage(driver);
			 op.clickOnCreateOrg();
	 CreateOrganizationPage co= new CreateOrganizationPage(driver);
	    co.createOrg(orgName);
	   Thread.sleep(10000);
	   
	    hp.clickOnContactsLink();
	    ContactPage cp = new ContactPage(driver);
	    cp.clickOnCreateContact();
	    Assert.fail();
	    
	    CreateContactPage ccp = new CreateContactPage(driver);
	           ccp.createContactWithOrg(orgName, CONTACT, driver);
	    
	           
	}
}

