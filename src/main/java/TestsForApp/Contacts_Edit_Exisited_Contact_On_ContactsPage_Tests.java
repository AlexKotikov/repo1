package TestsForApp;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;
 

import org.testng.annotations.Test;

public class Contacts_Edit_Exisited_Contact_On_ContactsPage_Tests extends TestBase {
	
	@Test (dataProvider = "randomValidContactsGenerator")
    public void changeNameOfExistedContact( ContactsDataStructure   obj)  { 	
	 
       app.getNavigationHelper().goToSiteHome();
       List<ContactsDataStructure>  oldcon = app.getContactsHelper().GetContacts() ;
       
       int a = selectRandomContact(oldcon);
       
       app.getContactsHelper().selectExistedContactViewLink(a);
       app.getContactsHelper().modifiyForm();
       app.getContactsHelper().sendDataToContacts(obj);
       app.getContactsHelper().updateForm();
       app.getNavigationHelper().backToHomePage();
       
       List<ContactsDataStructure>  newcon = app.getContactsHelper().GetContacts() ;
     //  System.out.println (  " deleted:     " + oldcon.get(0).first + "   "+  oldcon.get(0).last ); 
       oldcon.remove(a);
       oldcon.add(obj.swapFirstAndLast());    
	   Collections.sort(oldcon);
       Collections.sort(newcon);
     //   for (ContactsDataStructure a :  oldcon) {  	System.out.println (a.first +"     " + a.last); 	 }  	   
  	 //   System.out.println ("  ------new----");  	      for (ContactsDataStructure a :  newcon) {
  	 //   System.out.println (a.first +"     " + a.last); 	  	 	   } 
   
       
       assertEquals( newcon, oldcon); 
       
	}

	
	
}