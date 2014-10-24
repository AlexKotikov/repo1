package TestsForApp;

import org.testng.annotations.Test;

public class Birthdays_Edit_Exisited_Tests extends TestBase {
	
	@Test
    public void changeNameOfExistedContact() { 	
	 
       app.getNavigationHelper().goToSiteHome();
       app.getNavigationHelper().goToBirthdaysPage();
       app.getBirthdaysHelper().selectExistedContactEditLink(1);
       
       
       ContactsDataStructure obj = new ContactsDataStructure();
       obj.first	=   "Vasya";
       obj.last = "Selenium-birthdays2";
      
       app.getContactsHelper().sendDataToContacts(obj);
       app.getBirthdaysHelper().updateForm();
       app.getNavigationHelper().goToBirthdaysPage();
       
	}
	
}