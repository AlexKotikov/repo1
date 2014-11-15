package TestsForApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import com.example.utils.SortedListOf;
import com.google.common.collect.Lists;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is; 


public class Contacts_check_Phones extends TestBase {
 
	@Test 
	 public void testThatContactsMatchOn() throws Exception 
		{   
		   SortedListOf<ContactsDataStructure>  onMainPage = app.getContactsHelper().GetContacts();  
		   SortedListOf<ContactsDataStructure>  onPhonesPage = app.getContactsHelper().getContactsFromPhones();
		   assertThat(onMainPage, equalTo(onPhonesPage)); 
		} 
	
	
     @Test  
     public void testRegExpOfPhones() throws Exception 
	{   
		app.navigateTo().homePage();
    	SortedListOf<ContactsDataStructure>  phones_list = app.getContactsHelper().getContactsFromPhones();
	    assertThat( app.getContactsHelper().regxmatcher(phones_list), is(true));
	}  
}


//for (ContactsDataStructure a: phones_list) {     	System.out.println(a.getFirst() + a.getLast() 
		  // + a.getEmail1()+	 a.getMobile());    }
