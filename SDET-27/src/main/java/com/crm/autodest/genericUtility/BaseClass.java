package com.crm.autodest.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.pomReposityLib.HomePage;
import com.crm.autodesk.pomReposityLib.LoginPage;

public class BaseClass {
	
	public DataBaseUtility dLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"smokeSuite","RegressionSuite"})
	public void dbConnection()
	{
	dLib.connectToDB();
	System.out.println("=========Database connection successful====");
	}
	
	@Parameters("browser")
	@BeforeClass(groups = {"smokeSuite","RegressionSuite"})
	public void launchBrowser() throws IOException
	{
		//read the data
		String Browser = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		if(Browser.equals("firefox")) {
			driver = new FirefoxDriver();
			}else if(Browser.equals("chrome")) {
				driver = new ChromeDriver();
			}else if (Browser.equals("ie")) {
				driver = new InternetExplorerDriver();
			}else {
				driver = new ChromeDriver();	
				}
		sdriver = driver;
		wLib.waitForPageToLoad(driver);
		wLib.maximiseWindow(driver);
		driver.get(URL);
		System.out.println("=====browser launched=======");
		
	}
	
	@BeforeMethod(groups = {"smokeSuite","RegressionSuite"})
	public void loginToApp() throws IOException
	{
	String USERNAME = fLib.getPropertyKeyValue("username");	
	String PASSWORD = fLib.getPropertyKeyValue("password");
	
	LoginPage lp = new LoginPage(driver);
	lp.login(USERNAME, PASSWORD);
	System.out.println("======Login Successful====");
	}
	
	@AfterMethod(groups = {"smokeSuite","RegressionSuite"})
	public void logoutApp()
	{
	HomePage hp = new HomePage(driver);
	hp.logout(driver);
	System.out.println("====Logout successful=====");
	}
	@AfterClass(groups = {"smokeSuite","RegressionSuite"})
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("=====browser closed======");
	}
	@AfterSuite(groups = {"smokeSuite","RegressionSuite"})
	public void closeDbConnection()
	{
		dLib.closeDB();
		System.out.println("=====Database connection closed====");
	}
}
