package com.example.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;


public class Contacts_Delete_Exisited_Contact_Tests extends TestBase {
	
	@Test
    public void changeNameOfExistedContact() { 	
	 
	   SortedListOf<ContactsDataStructure>  oldcon = //app.getContactsHelper().getUIContacts() ;
			   app.getModelHelper().getContacts(); 
			   
			   
	   int a  =  app.getContactsHelper().selectRandomContact(oldcon); 
	   			
	   		     app.getContactsHelper().deleteExistedContact(a);
       
       SortedListOf<ContactsDataStructure>  newcon = //app.getContactsHelper().getUIContacts() ;
    		   app.getModelHelper().getContacts();
    		   
    		   
       // System.out.println("---New List---"); 
	   //for(ContactsDataStructure as:  newcon) {System.out.println(as);}
   
       assertThat(oldcon, equalTo(newcon)); 

       
       if (checking("ui")){
	    	 newcon  = app.getContactsHelper().getUIContacts(); 
	    		assertThat(oldcon, equalTo(newcon));
	    		}
	     
	     if (checking("db")){
	    	 newcon  = new  SortedListOf<ContactsDataStructure>(app.GetHibernateHelper().listContacts());
	    		assertThat(oldcon, equalTo(newcon));
	    		System.out.println("DB");
	    		}
	     
       
       
       
       
	}

	
	
}