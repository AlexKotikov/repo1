package com.example.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class Contacts_Edit_Exisited_Contact_On_ContactsPage_Tests extends TestBase {
	
	@Test (dataProvider = "randomValidContactsGenerator")
    public void changeNameOfExistedContact( ContactsDataStructure   obj)  { 	
		
	SortedListOf<ContactsDataStructure>  oldcon = //app.getContactsHelper().getUIContacts();
			app.getModelHelper().getContacts();
			
       int a = app.getContactsHelper().selectRandomContact(oldcon);
       
       app.getContactsHelper().modifyForm(obj, a);
       
       SortedListOf<ContactsDataStructure>  newcon = //app.getContactsHelper().getUIContacts() ;
    		   app.getModelHelper().getContacts();
    		   
    		   
      // System.out.println("---New List---"); 
	  // for(ContactsDataStructure as:  newcon) {System.out.println(as);} 
      
		assertThat(newcon  ,
				equalTo(oldcon.without(a).withAdded(obj)));  
		
		 if (checking("ui")){
	    	 newcon  = app.getContactsHelper().getUIContacts(); 
	    		assertThat(newcon, 
	    				equalTo(oldcon.without(a).withAdded(obj)));  
	    		}
	     
	     if (checking("db")){
	    	 newcon  = 
	    			 new  SortedListOf<ContactsDataStructure>(app.GetHibernateHelper().listContacts());
	    	 assertThat(newcon, 
	    			 equalTo(oldcon.without(a).withAdded(obj)));  
	     }
		
	}
}