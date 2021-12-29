package com.crm.autodesk.pomReposityLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodest.genericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	

	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement PasswordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	
	
	
	public void login(String username, String password) {
		
		userNameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		loginBtn.click();
	}

}
