package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	@FindBy(xpath="//div[.='Time-Track']")
	private WebElement timetracktab;
	
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement tasktab;
	
	@FindBy(xpath="//div[.='Reports']")
	private WebElement reporttab;
	
	@FindBy(xpath="//div[.='Users']")
	private WebElement userstab;
	
	@FindBy(id="logoutLink")
	private WebElement logoutlink;
	
	//initialization
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTimetracktab() {
		return timetracktab;
	}

	public WebElement getTasktab() {
		return tasktab;
	}

	public WebElement getReporttab() {
		return reporttab;
	}

	public WebElement getUserstab() {
		return userstab;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	//utilization
	
}
