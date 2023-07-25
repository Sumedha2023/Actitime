package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListenerImplementation;
import com.Actitime.ObjectRepository.Homepage;
import com.Actitime.ObjectRepository.TaskPage;
@Listeners(ListenerImplementation.class)

public class CreateCustomer extends BaseClass {
	
	@Test
	public void createcustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		Homepage hp=new Homepage(driver);
		hp.getTasktab().click();
		TaskPage tp= new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		FileLibrary f= new FileLibrary();
		String name = f.readDatafromExcel("Bank", 2, 1);
		System.out.println(name);
		tp.getCustname().sendKeys(name);
		
		String desp = f.readDatafromExcel("Bank", 2, 2);
	
		tp.getCustdesp().sendKeys(desp);
		tp.getCreatecustbtn().click();
	}
}
