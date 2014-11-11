package TestsForApp;

import static com.example.fw.ContactsHelper.CREATION;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.AssertJUnit.assertEquals;
import java.util.Collections;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
 

public class Contacts_Add_New_Contact_Tests extends TestBase {
 
	 //@Test  (dataProvider = "randomValidContactsGenerator")
	  public void testCase1( ContactsDataStructure  obj) throws Exception 
	  {
		SortedListOf<ContactsDataStructure>  oldcon = app.getContactsHelper().GetContacts() ;
		
		app.getContactsHelper().makeNewContcact(obj); 
	       
	    SortedListOf<ContactsDataStructure>  newcon = app.getContactsHelper().GetContacts() ;
            
	      		System.out.println("---New List---"); 
	    		for(ContactsDataStructure a:  newcon) {System.out.println(a);}
		
        assertThat(newcon, equalTo(oldcon.withAdded(obj.swapFirstAndLast()))); 
	 }

	
	 
	@Test
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
           ;
	     
	     app.navigateTo().backToHomePage();
	     SortedListOf<ContactsDataStructure> oldSorted = app.getContactsHelper().GetContacts();
	     
	     app.getContactsHelper().startToAddingOfNewContact();
	      
	     app.getContactsHelper().sendDataToContacts( validdata  ,true);
	     app.getContactsHelper().sendContactsForm();
	     app.navigateTo().backToHomePage();
	     
	     SortedListOf<ContactsDataStructure>  newcon = app.getContactsHelper().GetContacts();  
   		
	     System.out.println("---New List---"); 
 		 for(ContactsDataStructure a:  newcon) {System.out.println(a);}
 		
 		
	     assertThat(newcon, equalTo(oldSorted.withAdded(validdata.swapFirstAndLast()))); 
	     
	     
	     
	     
	     
	   }
	 
	 
}
