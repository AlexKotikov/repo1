package com.example.fw;

import org.openqa.selenium.By;
 

import TestsForApp.ContactsDataStructure;

public class ContactsHelper extends HelperBase {

	public ContactsHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void sendDataToContacts( ContactsDataStructure data) {		
		type(By.name("firstname"), data.first);	
		type(By.name("lastname"),data.last);
		type(By.name("address"),data.address);
		type(By.name("home"),data.home);
		type(By.name("mobile"),data.mobile);
		type(By.name("work"),data.work);
		type(By.name("email"),data.email1);
		type(By.name("email2"),data.email2);
		type(By.name("byear"),data.byear);
		type(By.name("address2"),data.address2);
		type(By.name("address2"),data.secondaryAddress);
		type(By.name("phone2"),data.homepage);			 
		selectByText(By.name("bday"), data.day);
	    selectByText(By.name("bmonth"), data.month);	 
	}

	public void selectExistedContactEditLink(int index) {
		//click (By.xpath("//tr[@name=\"entry\"]["+index+"]/td/input[@type=\"checkbox\"]"));
		click (By.xpath("//tr[@name=\"entry\"]["+index +"]/td/a[starts-with(@href, \"edit.php\")]"));
	}

	public void selectExistedContactViewLink(int index) {
		click (By.xpath("//tr[@name=\"entry\"]["+index +"]/td/a[starts-with(@href, \"view.php\")]"));
		
	}

	public void selectExistedContactEditLinkFromBirthdays (int index) {
		click (By.xpath("//tr[@class=\"odd\"]["+ index +"]/td/a[starts-with(@href, \"edit.php\")]"));
		
	}
	
	public void deleteForm() {
		click (By.xpath("//form[@action=\"delete.php\"]/input[@type=\"submit\"]"));	
	}

}
