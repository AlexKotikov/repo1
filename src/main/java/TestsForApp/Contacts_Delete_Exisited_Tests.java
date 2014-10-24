package TestsForApp;

import org.testng.annotations.Test;

public class Contacts_Delete_Exisited_Tests extends TestBase {
	
	@Test
    public void changeNameOfExistedContact() { 	
	 
       app.getNavigationHelper().goToSiteHome();
       app.getContactsHelper().selectExistedContactEditLink(1);
       app.getContactsHelper().deleteForm();
       app.getNavigationHelper().backToHomePage();
       
	}
	
}