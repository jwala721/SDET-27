package com.crm.autodest.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * It contains WebDriver specific reusable actions
 * @author JWALA KUMAR
 *
 */
public class WebDriverUtility {
	/**
	 * wait for page to load before identifying any sychronized element in DOM[HTML-Document]
	 * @param driver
	 */
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	/**
	 * used to wait for element to be clickable in GUI, and check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 */
	public void waitForPageToBeClickAble(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	/**
	 * use to wait for element to be clickable in GUI, and check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws InterruptedException
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws InterruptedException {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	/**
	 * use to switch to any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindoeTitle = driver.getTitle();
			if(currentWindoeTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	
	/**
	 * user to switch to alert window and click on cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		
	driver.switchTo().alert().accept();
	}

/**
 * used to switch to frame window based on index
 * @param driver
 * @param index
 */

    public void switchToFrame(WebDriver driver, int index) {
    	driver.switchTo().frame(index);
	}
    
    /**
     * used to switch to frame window based on id or name attribute
     * @param driver
     * @param id_name_attribute
     */
    public void switchToFrame(WebDriver driver, String id_name_attribute) {
    	driver.switchTo().frame(id_name_attribute);
    }
    /**
     * used to select the value from the dropdown based on index
     * @param element
     * @param index
     */
    public void select(WebElement element, int index) {
    	Select sel = new Select(element);
    	sel.deselectByIndex(index);
    }
    /**
     * used to select the value from the dropdown based on value
     * @param element
     * @param text
     */
    public void select(WebElement element, String text) {
    	Select sel = new Select(element);
    	sel.selectByVisibleText(text);
    }
    /**
     * used to place mouse cursor on specified element
     * @param driver
     * @param element
     */
    
    public void mouseOverElement(WebDriver driver, WebElement element) {
    	Actions act = new Actions(driver);
    	act.moveToElement(element).perform();
    }
    /**
     * used to right click on specified element
     * @param driver
     * @param element
     */
    public void rightClickOnElement(WebDriver driver, WebElement element) {
    	Actions act = new Actions(driver);
    	act.contextClick(element).perform();
    }
    /**
     * used to handle disabled elements
     * @param driver
     * @param javaScript
     */
    public void executeJavaScript(WebDriver driver, String javaScript) {
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeAsyncScript(javaScript, null);
    }
    /**
     * to handle exception
     * @param element
     * @throws InterruptedException 
     */
    public void waitAndClick(WebElement element) throws InterruptedException {
    	  int count = 0;
    	  while(count<20) {
    		  try {
    			  element.click();
    			  break;
    		  }catch(Throwable e) {
    			  Thread.sleep(1000);
    			  count++;
    		  }
    	  }
    }
    
    /**
     * used to take screenshot
     * @param driver
     * @param screenshotName
     * @throws IOException
     */
    public void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File("./screenshot/"+screenshotName+".PNG");
    	Files.copy(src, dest);
    }
    /**
     * pass enter key appertain in to browser 
     * @param driver
     */
    public void passEnterKey(WebDriver driver) {
    	Actions act = new Actions(driver);
    	act.sendKeys(Keys.ENTER).perform();
    }
    
    public void maximiseWindow(WebDriver driver)
    {
    	driver.manage().window().maximize();
    }
    
    
}