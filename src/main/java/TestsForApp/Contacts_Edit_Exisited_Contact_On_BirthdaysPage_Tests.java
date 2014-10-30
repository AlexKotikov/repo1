package TestsForApp;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class Contacts_Edit_Exisited_Contact_On_BirthdaysPage_Tests extends TestBase {
	
	@Test  
    public void changeNameOfExistedContact() { 	
	 
       app.getNavigationHelper().goToSiteHome();
       app.getNavigationHelper().goToBirthdaysPage();
      
 
       app. getContactsHelper().selectExistedContactEditLinkFromBirthdays(1);
       
       
       ContactsDataStructure obj = new ContactsDataStructure();
       obj.first	=   "Vasya";
       obj.last = "Selenium-birthdays2222";
      
       app.getContactsHelper().sendDataToContacts(obj);
       app.getContactsHelper().updateForm();
       app.getNavigationHelper().goToBirthdaysPage();
      
   
	}
	
}