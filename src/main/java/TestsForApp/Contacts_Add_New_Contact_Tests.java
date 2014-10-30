package TestsForApp;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;


import org.testng.annotations.Test;
 


public class Contacts_Add_New_Contact_Tests extends TestBase {
 
	 @Test  (dataProvider = "randomValidContactsGenerator")
	  public void testCase2( ContactsDataStructure  obj) throws Exception {
	    app.getNavigationHelper().goToSiteHome();

	    List<ContactsDataStructure>  oldcon = app.getContactsHelper().GetContacts() ;
  
	    app.getContactsHelper().startToAddingOfNewContact();
	    app.getContactsHelper().sendDataToContacts(obj);
	    app.getContactsHelper().sendContactsForm();
	    app.getNavigationHelper().goToSiteHome();
	    
	    List<ContactsDataStructure>  newcon = app.getContactsHelper().GetContacts() ;
        oldcon.add(obj.swapFirstAndLast());    
	    Collections.sort(oldcon);
        Collections.sort(newcon);
	    
	
         assertEquals( newcon, oldcon); 
	    
	 }
}
