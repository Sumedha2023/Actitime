package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	@FindBy(id="username")
	private WebElement untbx;
	@FindBy(name="pwd")
	private WebElement pwttbx;
	@FindBy(xpath="//div[.='Login ']")
	private WebElement btn;
	
	//initialization--->create constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwttbx() {
		return pwttbx;
	}

	public WebElement getBtn() {
		return btn;
	}	
}
