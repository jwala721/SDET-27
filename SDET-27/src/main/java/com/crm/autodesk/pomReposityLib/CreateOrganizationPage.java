package com.crm.autodesk.pomReposityLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodest.genericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	

	@FindBy(name ="accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name ="industry")
	private WebElement industryDropdown;
	@FindBy(name ="accounttype")
	private WebElement typeDropeDown;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}


	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}


	public WebElement getTypeDropeDown() {
		return typeDropeDown;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String orgName) {
		organizationNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrgWithIndustryAndType(String orgName, String industryType , String type)
	{
		organizationNameEdt.sendKeys(orgName);
		select(industryDropdown, industryType);
		select(typeDropeDown, type);
		saveBtn.click();
	}
	

}
