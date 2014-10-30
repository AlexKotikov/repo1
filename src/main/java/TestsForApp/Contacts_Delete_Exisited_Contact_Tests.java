package TestsForApp;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class Contacts_Delete_Exisited_Contact_Tests extends TestBase {
	
	@Test
    public void changeNameOfExistedContact() { 	
	 
       app.getNavigationHelper().goToSiteHome();
       
       List<ContactsDataStructure>  oldcon = app.getContactsHelper().GetContacts() ;
       
       int a  =  selectRandomContact(oldcon);
       
       app.getContactsHelper().selectExistedContactEditLink(a);
       app.getContactsHelper().deleteForm();
       app.getNavigationHelper().backToHomePage();
       List<ContactsDataStructure>  newcon = app.getContactsHelper().GetContacts() ;
       
       oldcon.remove(a);
       Collections.sort(oldcon);
       Collections.sort(newcon);
       assertEquals( newcon, oldcon); 
	}
	
}