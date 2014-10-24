package TestsForApp;

import org.testng.annotations.Test;

public class Contacts_Modify_Exisited_Tests extends TestBase {
	
	@Test
    public void changeNameOfExistedContact() { 	
	 
       app.getNavigationHelper().goToSiteHome();
       app.getContactsHelper().selectExistedContactEditLink(1);
       
       
       ContactsDataStructure obj = new ContactsDataStructure();
       obj.first	=   "Vasya";
       obj.last = "Selenium";
      
       app.getContactsHelper().sendDataToContacts(obj);
       
       app.getContactsHelper().updateForm();
       app.getNavigationHelper().backToHomePage();
       
	}
	
}