package com.crm.autodest.product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodest.genericUtility.ExcelUtility;
import com.crm.autodest.genericUtility.FileUtility;
import com.crm.autodest.genericUtility.JavaUtility;
import com.crm.autodest.genericUtility.WebDriverUtility;

public class SearchProductBy_CommissionRate {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib =new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		int randomNum = jLib.getRanDomNumber();
		
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");
	String COMMRATE = fLib.getPropertyKeyValue("CommissionRate");
	
	String productName = eLib.getDataFromExcel("product", 1, 1) + randomNum;
	String Type = eLib.getDataFromExcel("product", 1, 4);


WebDriver driver;
if(BROWSER.equals("firefox")) {
driver = new FirefoxDriver();
}else if(BROWSER.equals("chrome")) {
	driver = new ChromeDriver();
}else if (BROWSER.equals("ie")) {
	driver = new InternetExplorerDriver();
}else {
	driver = new ChromeDriver();
}

wLib.waitForPageToLoad(driver);	

driver.get(URL);
driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();

driver.findElement(By.linkText("Products")).click();
driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
driver.findElement(By.name("productname")).sendKeys(productName);
driver.findElement(By.id("commissionrate")).sendKeys(COMMRATE);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

driver.findElement(By.linkText("Products")).click();
//driver.findElement(By.)

driver.findElement(By.name("search_text")).sendKeys(COMMRATE);

wLib.select(driver.findElement(By.id("bas_searchfield")), Type);
driver.findElement(By.name("submit"));

	
	}
}
