package com.crm.autodesk.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.pomReposityLib.CreateOrganizationPage;
import com.crm.autodesk.pomReposityLib.HomePage;
import com.crm.autodesk.pomReposityLib.LoginPage;
import com.crm.autodesk.pomReposityLib.OrganizationInfoPage;
import com.crm.autodesk.pomReposityLib.OrganizationsPage;
import com.crm.autodest.genericUtility.BaseClass;
import com.crm.autodest.genericUtility.ExcelUtility;
import com.crm.autodest.genericUtility.FileUtility;
import com.crm.autodest.genericUtility.JavaUtility;
import com.crm.autodest.genericUtility.WebDriverUtility;

public class CreateOrg extends BaseClass {
	
	@Test(groups = "smokeSuite")
	public void createOrgTest() throws EncryptedDocumentException, IOException  {
		
		//get RanDom Num
		int randomNum = jLib.getRanDomNumber();
		
		//read test data from Excel File
	String orgName = eLib.getDataFromExcel("org", 1, 2) + randomNum;
	
	//step2 : navigate to Organization module
	HomePage hp = new HomePage(driver);
	hp.clickOnorganizationsLnk();
	
	//step 3: click on "Create Organization" button
	OrganizationsPage op = new OrganizationsPage(driver);
	op.clickOnCreateOrg();
	
	//step4: enter all the details and create new Organization
	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	cop.createOrg(orgName);
	
	//step5 : verfiy Organization name in header of the msg
	   OrganizationInfoPage oip = new OrganizationInfoPage(driver);
       String ActMsg = oip.getOrgInfo();
		
		
       Assert.assertTrue(ActMsg.contains(orgName));
		System.out.println("contact created sucessfully");
		
		/*SoftAssert sa = new SoftAssert();
		sa.assertTrue(ActMsg.contains(orgName));
		Reporter.log("contact created", true);
		sa.assertAll();*/
	}
		@Test
		public void createOrgDemo()
		{
			System.out.println("demo");
		}

	
	}	




