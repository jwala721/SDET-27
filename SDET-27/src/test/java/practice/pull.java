package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodest.genericUtility.ExcelUtility;
import com.crm.autodest.genericUtility.FileUtility;
import com.crm.autodest.genericUtility.JavaUtility;
import com.crm.autodest.genericUtility.WebDriverUtility;

public class pull {
	
	
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
	String QTYSTOCK = fLib.getPropertyKeyValue("QtyInStock");
	
	String productName = eLib.getDataFromExcel("product", 1, 1) + randomNum;
	String QYT = eLib.getDataFromExcel("product", 1, 5);


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
driver.findElement(By.id("qtyinstock")).sendKeys(QTYSTOCK);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

driver.findElement(By.linkText("Products")).click();
driver.findElement(By.name("search_text")).sendKeys(QTYSTOCK);

wLib.select(driver.findElement(By.id("bas_searchfield")), QYT);

driver.findElement(By.name("submit"));
	
	}

}


