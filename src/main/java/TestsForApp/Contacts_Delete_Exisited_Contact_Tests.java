package TestsForApp;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class Contacts_Delete_Exisited_Contact_Tests extends TestBase {
	
	@Test
    public void changeNameOfExistedContact() { 	
	 
	   SortedListOf<ContactsDataStructure>  oldcon = app.getContactsHelper().GetContacts() ;
       
	   int a  =  app.getContactsHelper().selectRandomContact(oldcon); 
	   
	   		     app.getContactsHelper().deleteExistedContact(a);
       
       SortedListOf<ContactsDataStructure>  newcon = app.getContactsHelper().GetContacts() ;
      
       System.out.println("---New List---"); 
	   for(ContactsDataStructure as:  newcon) {System.out.println(as);}
   
       assertThat(newcon, equalTo(oldcon.without(a))); 

	}

	
	
}