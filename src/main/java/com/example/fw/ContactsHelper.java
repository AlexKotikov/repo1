package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 

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
		click (By.xpath("//tr[@name=\"entry\"]["+(index +1)  +"]/td/a[starts-with(@href, \"edit.php\")]"));
	}

	public void selectExistedContactViewLink(int index) {
		click (By.xpath("//tr[@name=\"entry\"]["+(index+1) +"]/td/a[starts-with(@href, \"view.php\")]"));
		
	}

	public void selectExistedContactEditLinkFromBirthdays (int index) {
		click (By.xpath("//tr[@class=\"odd\"]["+ index +"]/td/a[starts-with(@href, \"edit.php\")]"));
		
	}
	
	public void deleteForm() {
		click (By.xpath("//form[@action=\"delete.php\"]/input[@type=\"submit\"]"));	
	}
  
	public List<ContactsDataStructure> GetContacts() {
		List<ContactsDataStructure>  contacts = new ArrayList<ContactsDataStructure>();
		
		String trpath = "//tr[@name=\"entry\"]";
		
		
		
		if (  driver.findElements(By.xpath(trpath)).size() > 0) {
		
		List<WebElement> checkboxes = driver.findElements(By.xpath(trpath));
		
	 ///	for (WebElement webElement : checkboxes) {  
		
		  for (int i=1; i<checkboxes.size()+1;i++) {
	    
			ContactsDataStructure contact = new ContactsDataStructure();
			
			contact.first = driver.findElement(By.xpath(trpath+"["+i+ "]/td[2]")).getText();
			contact.last  =  driver.findElement(By.xpath(trpath+"["+i+ "]/td[3]")).getText();
			contact.email1 = driver.findElement(By.xpath(trpath+"["+i+ "]/td[4]")).getText();
						
			contacts.add(contact);
	     	}
		  
		} else  throw new Error(" Контактов на форме нету!");
			 
        
		return contacts;
        
		
        
	}  

	
}
