package com.example.fw;

import static com.example.fw.ContactsHelper.CREATION;
import static com.example.fw.ContactsHelper.MODIFICATION;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.utils.SortedListOf;
 

import TestsForApp.ContactsDataStructure;
 
 

public class ContactsHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactsHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public ContactsHelper sendDataToContacts( ContactsDataStructure data, boolean formType) {		
		type(By.name("firstname"), data.getFirst());	
		type(By.name("lastname"),data.getLast());
		type(By.name("address"),data.getAddress());
		type(By.name("home"),data.getHome());
		type(By.name("mobile"),data.getMobile());
		type(By.name("work"),data.getWork());
		type(By.name("email"),data.getEmail1());
		type(By.name("email2"),data.getEmail2());
		type(By.name("byear"),data.getByear());
		type(By.name("address2"),data.getAddress2());
		type(By.name("address2"),data.getSecondaryAddress());
		type(By.name("phone2"),data.getHomepage());			 
		selectByText(By.name("bday"), data.getDay());
	    selectByText(By.name("bmonth"), data.getMonth());	
	    
	    if (formType == CREATION) {
	    // 1		    	
	    } else {
	    // 2 	
	    }
	    
	    return this;
	}

	public void modifyForm(ContactsDataStructure obj, int a) {
		      
		       selectExistedContactViewLink(a);
		       modifiyForm();
		       sendDataToContacts(obj, MODIFICATION);
		       updateForm();
		       returnOnContactsPage() ;
		     
	}
	
	
	
	public void makeNewContcact(ContactsDataStructure obj) {
		  
		
	        startToAddingOfNewContact();
	        sendDataToContacts(obj, CREATION) ;
	        sendContactsForm();
	        returnOnContactsPage();
	       
	}
	
	public void deleteExistedContact(int a) {
		  
		   
	   
	   selectExistedContactEditLink(a);
	   deleteForm();
	   returnOnContactsPage() ;
}
	
	
	public int selectRandomContact(SortedListOf<ContactsDataStructure> oldcon) {
		Random digit = new Random(); 
		   int a =digit.nextInt(oldcon.size());
		return a;
	}
	
	
	public ContactsHelper selectExistedContactEditLink(int index) {
		//click (By.xpath("//tr[@name=\"entry\"]["+index+"]/td/input[@type=\"checkbox\"]"));
		click (By.xpath("//tr[@name=\"entry\"]["+(index +1)  +"]/td/a[starts-with(@href, \"edit.php\")]"));
		return this;
	}

	public ContactsHelper selectExistedContactViewLink(int index) {
		click (By.xpath("//tr[@name=\"entry\"]["+(index+1) +"]/td/a[starts-with(@href, \"view.php\")]"));
		return this;
	}
	
	public ContactsHelper modifiyForm() {
		click(By.name("modifiy"));
		return this;
	}

	public ContactsHelper selectExistedContactEditLinkFromBirthdays (int index) {
		click (By.xpath("//tr[@class=\"odd\"]["+ index +"]/td/a[starts-with(@href, \"edit.php\")]"));
		return this;
	}
	
	public ContactsHelper deleteForm() {
		click (By.xpath("//form[@action=\"delete.php\"]/input[@type=\"submit\"]"));	
		ConCache =  null;
		return this;
	}
    
	public ContactsHelper startToAddingOfNewContact() {
        click(By.linkText("add new"));
		return this;
	}
	 
	public ContactsHelper sendContactsForm() {
		 click(By.name("submit"));
		 ConCache =  null;
		 return this;	 
	}
	
	
	private static SortedListOf<ContactsDataStructure>  ConCache = null;
	
	
	public SortedListOf<ContactsDataStructure> GetContacts() {
		
		if (ConCache == null ){
			return letsBuildCache() ;
		}
		
		return ConCache;
		}
		
		public SortedListOf<ContactsDataStructure> letsBuildCache() {
		//SortedListOf<ContactsDataStructure>  contacts = new SortedListOf<ContactsDataStructure>();
		 
		String trpath = "//tr[@name=\"entry\"]";

		List<WebElement> checkboxes = driver.findElements(By.xpath(trpath));
		 
		SortedListOf<ContactsDataStructure> ff =  new SortedListOf<ContactsDataStructure>(); 

		  for (int i=1; i<checkboxes.size()+1;i++) {
	    
			ContactsDataStructure contact = new ContactsDataStructure();
			
			contact.setFirst(driver.findElement(By.xpath(trpath+"["+i+ "]/td[2]")).getText());
			contact.setLast(driver.findElement(By.xpath(trpath+"["+i+ "]/td[3]")).getText());
			contact.setEmail1(driver.findElement(By.xpath(trpath+"["+i+ "]/td[4]")).getText());	
			ff.add(contact);
	     	}
		  
		  ConCache = ff;
		  
		  return ConCache;
	}

	public ContactsHelper returnOnContactsPage() {
		click(By.linkText("home"));
		return this;
		
	}  

	public ContactsHelper updateForm() {

		click(By.name("update"));
		ConCache = null;
		return this;
	}
}
