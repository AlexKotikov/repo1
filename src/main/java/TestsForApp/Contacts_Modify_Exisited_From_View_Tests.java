package TestsForApp;

import org.testng.annotations.Test;

public class Contacts_Modify_Exisited_From_View_Tests extends TestBase {
	
	@Test
    public void changeNameOfExistedContact() { 	
	 
       app.getNavigationHelper().goToSiteHome();
       app.getContactsHelper().selectExistedContactViewLink(1);
       app.getContactsHelper().modifiyForm();
      
       
       ContactsDataStructure obj = new ContactsDataStructure();
       obj.first	=   "Vasya-UPDATED";
       obj.last = "Selenium";
      
       app.getContactsHelper().sendDataToContacts(obj);
       
       app.getContactsHelper().updateForm();
       app.getNavigationHelper().backToHomePage();
       
	}
	
}