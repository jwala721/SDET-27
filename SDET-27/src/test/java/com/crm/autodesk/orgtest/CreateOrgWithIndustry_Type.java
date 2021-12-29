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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

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

public class CreateOrgWithIndustry_Type extends BaseClass {
	
	@Test(groups = "RegressionSuite")
	public  void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
	
	
	int randomNum = jLib.getRanDomNumber();
		
	
	String orgName = eLib.getDataFromExcel("org", 1, 2) + randomNum;
		
		
		String indName = eLib.getDataFromExcel("contact", 1, 3);
		String typeName = eLib.getDataFromExcel("contact", 4, 4);
		

    HomePage hp = new HomePage(driver);
        hp.clickOnorganizationsLnk();
        
        OrganizationsPage op= new OrganizationsPage(driver);
		   op.clickOnCreateOrg();
		   
		   CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		   cop.createOrgWithIndustryAndType(orgName, indName, typeName);
	 
		   OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String ActMsg = oip.getOrgInfo();
			
	Assert.assertTrue(ActMsg.contains(orgName)); 
}
	@Test
	public void demo()
	{
		System.out.println("demo");
	}
}
