package com.example.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;


public class Contacts_check_Phones extends TestBase {
 
	@Test 
	 public void testThatContactsMatchOn() throws Exception 
		{   
		   SortedListOf<ContactsDataStructure>  onMainPage = app.getContactsHelper().getUIContacts();  
		   SortedListOf<ContactsDataStructure>  onPhonesPage = app.getContactsHelper().getContactsFromPhones();
		   assertThat(onMainPage, equalTo(onPhonesPage)); 
		} 
	
	
     @Test  
     public void testRegExpOfPhones() throws Exception 
	{   
		
    	SortedListOf<ContactsDataStructure>  phones_list = app.getContactsHelper().getContactsFromPhones();
	    assertThat( app.getContactsHelper().regxmatcher(phones_list), is(true));
	}  
}


//for (ContactsDataStructure a: phones_list) {     	System.out.println(a.getFirst() + a.getLast() 
		  // + a.getEmail1()+	 a.getMobile());    }
