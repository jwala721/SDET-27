package com.crm.autodesk.pomReposityLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createOrgLookUpImg;
	
	@FindBy(name ="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name ="submit")
	private WebElement searchNowBtn;
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	

}
