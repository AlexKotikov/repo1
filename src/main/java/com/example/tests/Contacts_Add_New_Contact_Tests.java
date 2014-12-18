package com.example.tests;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static com.example.tests.ContactsGenerator.loadCSVfile; 
import static com.example.tests.ContactsGenerator.loadXMLfile;

public class Contacts_Add_New_Contact_Tests extends TestBase {
 
	 //@Test  (dataProvider = "randomValidContactsGenerator")
	 
	@DataProvider
	public Iterator<Object[]> loadCSV () throws IOException {
		 
		List<ContactsDataStructure>  conts  = loadCSVfile (new File ("conts.txt"));
		return conactstsWraper(conts).iterator();	 
		}
		 
	@DataProvider
	public Iterator<Object[]> loadXML () throws IOException {
		 
		List<ContactsDataStructure>  conts  = loadXMLfile (new File ("conts.xml"));
		return conactstsWraper(conts).iterator();	 
		}
				  	 
	 
	
	 @Test  (dataProvider = "loadXML")
	 public void testCase1( ContactsDataStructure  obj) throws Exception 
	  {
		SortedListOf<ContactsDataStructure>  oldcon = //app.getContactsHelper().GetContacts() ;
				new  SortedListOf<ContactsDataStructure>(app.getModelHelper().getContacts());
				
				
		app.getContactsHelper().makeNewContcact(obj); 
	       
	    SortedListOf<ContactsDataStructure>  newcon = //app.getContactsHelper().GetContacts() ;
            app.getModelHelper().getContacts();
	    		
	    		
	   
	      //	System.out.println("---New List---"); 
	     //   for(ContactsDataStructure a:  newcon) {System.out.println(a);}   
	    
	     assertThat(newcon, equalTo(oldcon.withAdded(obj))); //.swapFirstAndLast()
	    
	     
	     if (checking("ui")){
	    	 newcon  = app.getContactsHelper().getUIContacts(); 
	    		assertThat(newcon, equalTo(oldcon.withAdded(obj)));
	    		}
	     
	     if (checking("db")){
	    	 newcon  = new  SortedListOf<ContactsDataStructure>(app.GetHibernateHelper().listContacts());
	    		assertThat(newcon, equalTo(oldcon.withAdded(obj)));
	    		System.out.println("DB");
	    		}
	     
	     
	     
	 }

	
	 
	//@Test
	   public void testCase2() throws Exception {
	    		 
      ContactsDataStructure  validdata =  new ContactsDataStructure()
	      .withFirstName("Вася") 
	      .withSecondName("Петров") 
	      .withAddress("ул Ленина 12 13/1")	 
	      .withHome("Home") 
	      .withMobile("+79313939329")	 
	      .withWork("PM") 
	      .withEmail1("E12-mail@E12-mail.ru")	 
	      .withEmail2("E2-mail@E2-mail.ru")	 
	      .withByear("1988")    
	      .withAddress2("Москва Звезды 1  15\21")	 
	      .withSecondaryAddress("SecondaryAddress") 
	      .withHomepage("Homepage.ru")  
	      .withDay("17")  
	      .withMonth ("December") 
	      .withGroup ("1");
	     
	    
	     SortedListOf<ContactsDataStructure> oldSorted = //app.getContactsHelper().GetContacts();
	     new  SortedListOf<ContactsDataStructure>(app.GetHibernateHelper().listContacts());
	     
	     app.getContactsHelper().startToAddingOfNewContact();
	     app.getContactsHelper().sendDataToContacts(validdata,app.getContactsHelper().CREATION);
	     app.getContactsHelper().sendContactsForm();
	        
	     SortedListOf<ContactsDataStructure>  newcon = app.getContactsHelper().getUIContacts();  
 		 		
	     assertThat(newcon, equalTo(oldSorted.withAdded(validdata.swapFirstAndLast()))); 
	   }
}
