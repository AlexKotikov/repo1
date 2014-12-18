package com.example.fw;


import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

import com.example.tests.ContactsDataStructure;
import com.example.utils.SortedListOf;
 
 

public class ContactsHelper extends WebDriverBasedHelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	private static SortedListOf<ContactsDataStructure>  ConCache = null;
	
	
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
	       selectByText(By.name("new_group"), data.getGroup());   	
	      } else {
	     //ensure that there is no such element;  
	     //сквозная проверка
	     // assertTrue(isElementNotPresent(By.name("new_group")));
	    }
	    
	    return this;
	}

	
	
	
	
	public void modifyForm(ContactsDataStructure obj, int a) {
		      
		       selectExistedContactViewLink(a);
		       modifiyForm();
		       sendDataToContacts(obj, MODIFICATION);
		       manager.getModelHelper().removeContact(a).addContact(obj);
		       updateForm();
		       returnOnContactsPage() ;
		     
	}
	
	
	
	public void makeNewContcact(ContactsDataStructure obj) {
		  
		
	        startToAddingOfNewContact();		 // click link add
	        sendDataToContacts(obj, CREATION) ;  // fill in fields
	        manager.getModelHelper().addContact(obj);
	        
	        sendContactsForm();         		// click submit
	        returnOnContactsPage();
	       
	}
	
	public void deleteExistedContact(int a) {
			selectExistedContactEditLink(a);
			manager.getModelHelper().removeContact(a);
			deleteForm();
			returnOnContactsPage() ;
}
	
	
	public int selectRandomContact(SortedListOf<ContactsDataStructure> oldcon) {
		Random digit = new Random(); 
		   int a =digit.nextInt(oldcon.size());
		return a;
	}
	
	public SortedListOf<ContactsDataStructure> getUIContacts() {
		if (ConCache == null ){
		return letsBuildCache() ;
			}
		return ConCache;
	}
	
	public SortedListOf<ContactsDataStructure> letsBuildCache() {
			
		    manager.navigateTo().homePage();
			 
			String trpath = "//tr[@name=\"entry\"]";
		
			List<WebElement> checkboxes = driver.findElements(By.xpath(trpath));
			 
			SortedListOf<ContactsDataStructure> contacts =  new SortedListOf<ContactsDataStructure>(); 
		
			  for (int i=1; i<checkboxes.size()+1;i++) {
		    
				ContactsDataStructure contact = new ContactsDataStructure();
				contact.setFirst(driver.findElement(By.xpath(trpath+"["+i+ "]/td[3]")).getText());
				contact.setLast(driver.findElement(By.xpath(trpath+"["+i+ "]/td[2]")).getText());
				contact.setEmail1(driver.findElement(By.xpath(trpath+"["+i+ "]/td[4]")).getText());	
				contact.setMobile(driver.findElement(By.xpath(trpath+"["+i+ "]/td[5]")).getText());	
				
				contacts.add(contact);
		     	}
			  
			  ConCache = contacts;
			  
			  return ConCache;
}

	public SortedListOf<ContactsDataStructure> getContactsFromPhones() {
		 manager.navigateTo().homePage();
		 goToPhonesPage();				
		 
		 SortedListOf<ContactsDataStructure> phoneslist =  new SortedListOf<ContactsDataStructure>(); 
		  
         String xpathOfTableTR ="//table[@id=\"view\"]/tbody/tr";
		 String   first,last, infofromcell;
		     first = last  = infofromcell  = "";
		
		 List<WebElement> TRs = driver.findElements(By.xpath(xpathOfTableTR));
		 
		 for (int i=1 ; i<=TRs.size(); i++)
			 for (int i2=1 ; i2 <= 3; i2++) {
				 	
				 ContactsDataStructure contact = new ContactsDataStructure();
 				 infofromcell = driver.findElement(By.xpath(xpathOfTableTR+"["+i+"]/td["+i2+"]")).getText();
				 
				 if (infofromcell.indexOf(":") != -1)
				 {
					  last= infofromcell.substring(0, infofromcell.indexOf(" "));
					  first= infofromcell.substring(infofromcell.indexOf(" ")+1, infofromcell.indexOf(":"));
				      
				      contact.setFirst(first);  
			  	      contact.setLast(last);
			  	      contact.setMobile(parsePhonesList(infofromcell));
			  	      //System.out.println("F:"+first + " L:" + last + "P:" + parsePhonesList(infofromcell));
				      phoneslist.add(contact);
				 }

			 }
		 //System.out.println("---end---");
			return phoneslist ;
		}	
	
	
	public boolean regxmatcher(SortedListOf<ContactsDataStructure>  phones_list) {

		Pattern p = Pattern.compile("^[\\+]*\\d+(\\s)*(\\()*\\d*(\\))*[\\s]*(\\d|\\s)*(-|\\s)*(\\d+)*(-|\\s)*(\\d+)*$");
 
		 for (ContactsDataStructure a: phones_list) {     
			 
			 Matcher m = p.matcher(a.getMobile());
			 if(m.matches()) {
				  //  System.out.println("\"" + a + "\" - OK");
				}
				else {
				    System.out.println("\"" + a.getMobile()+ "\" - this value doesn't match the pattern: \n" + p +"\n");
				    return false;
					}  
		 }		 
    return  true; 
	}

	
	private  String  parsePhonesList(String a   ) {
 		String offset =	  "M: " ;
		 				// a.split(System.getProperty("line.separator")) ;
		    
			if (a.indexOf(offset) > 0) {  
			      if (a.indexOf("W: ") > 0)
				    a = a.substring(a.indexOf(offset)+offset.length(), a.indexOf("W: ") );
			      else  
			    	  a = a.substring(a.indexOf(offset)+offset.length());   
		     return a.trim();
			}  else 
					return "";
	}
	
	
//--------------------------------------------------------------------------------------------
	
	public ContactsHelper selectExistedContactEditLink(int index) {
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
	
		
	public ContactsHelper returnOnContactsPage() {
		click(By.linkText("home"));
		return this;
		
	}  

	public ContactsHelper updateForm() {
		click(By.name("update"));
		ConCache = null;
		return this;
	}	

	private  ContactsHelper goToPhonesPage() {
		click(By.linkText("print phones"));
		return this;
	}
	 

 
	
	
}
