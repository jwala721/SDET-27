package com.crm.autodesk.pomReposityLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodest.genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	@FindBy(linkText ="Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText ="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText ="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText ="Products")
	private WebElement productsLnk;
	
	
	public WebElement getProductsLnk() {
		return productsLnk;
	}

	@FindBy(linkText ="Documents")
	private WebElement documentsLnk;
	
	@FindBy(linkText ="Email")
	private WebElement emailLnk;
	
	@FindBy(linkText ="Trouble Tickets")
	private WebElement troubleTicketsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	

	@FindBy(linkText ="Sign Out")
	private WebElement signOutLnk;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}



	public WebElement getContactsLnk() {
		return contactsLnk;
	}



	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}



	public WebElement getDocumentsLnk() {
		return documentsLnk;
	}



	public WebElement getEmailLnk() {
		return emailLnk;
	}



	public WebElement getTroubleTicketsLnk() {
		return troubleTicketsLnk;
	}



	public WebElement getAdministratorImg() {
		return administratorImg;
	}



	public WebElement getSignOutLnk() {
		return signOutLnk;
	}



	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}
	
	public void clickOnProduct() {
		productsLnk.click();
	}
	
	public void clickOnorganizationsLnk()
	{
		organizationsLnk.click();
	}
	
	public void logout(WebDriver driver)
	{
		mouseOverElement(driver, administratorImg);
		signOutLnk.click();
	}
	}


