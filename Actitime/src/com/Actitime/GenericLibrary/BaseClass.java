package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.ObjectRepository.LoginPage;

public class BaseClass {
	FileLibrary f=new FileLibrary();
	public WebDriver driver;
	
	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("database connected", true);
	}
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String URL = f.readDataFrompropertyFile("url");
		driver.get(URL);
//		driver.get("https://demo.actitime.com/login.do");
		Reporter.log("Browser is launched successfully", true);
	}
	@BeforeMethod
	public void login() throws IOException {		
		String UN = f.readDataFrompropertyFile("username");		
		LoginPage lp=new LoginPage(driver);
		lp.getUntbx().sendKeys(UN);
		String PW = f.readDataFrompropertyFile("password");
		lp.getPwttbx().sendKeys(PW);
		lp.getBtn().click();
		Reporter.log("logged in successfully", true);
	}
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out successfully",true);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("browser closed successfully", true);
	}
	@AfterSuite
	public void disconnectdatabase() {
		Reporter.log("database disconnected sucessfully", true);
	}
}
