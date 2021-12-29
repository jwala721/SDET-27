package com.crm.autodesk.pomReposityLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy (xpath = "//img[@title='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	@FindBy(name ="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name ="submit")
	private WebElement searchNowBtn;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	
	public void clickOnCreateContact()
	{
		createContactLookUpImg.click();
	}

}
