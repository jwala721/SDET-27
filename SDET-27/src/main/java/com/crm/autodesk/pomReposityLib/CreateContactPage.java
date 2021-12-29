package com.crm.autodesk.pomReposityLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodest.genericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	@FindBy(name = "lastname")
	private WebElement contactLastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameLookImg;
	
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id = "search_txt")
	private WebElement orgSearchEdt;
	
	@FindBy(name="search")
	private WebElement searchClk;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactLastNameEdt() {
		return contactLastNameEdt;
	}

	public WebElement getOrgNameLookImg() {
		return orgNameLookImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public void createContact(String lastName)
	{
		contactLastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void orgLookUpImg() 
	
	{
		orgNameLookImg.click();
	}
	
	public void createContactWithOrg(String orgName, String lastName, WebDriver driver)
	{
		contactLastNameEdt.sendKeys(lastName);
		orgNameLookImg.click();
		switchToWindow(driver, "Accounts");
		orgSearchEdt.sendKeys(orgName);
		searchClk.click();
		driver.findElement(By.linkText(orgName)).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}

}
